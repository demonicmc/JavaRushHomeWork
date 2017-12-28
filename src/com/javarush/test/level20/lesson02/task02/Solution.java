package com.javarush.test.level20.lesson02.task02;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* Читаем и пишем в файл: JavaRush
Реализуйте логику записи в файл и чтения из файла для класса JavaRush
В файле your_file_name.tmp может быть несколько объектов JavaRush
Метод main реализован только для вас и не участвует в тестировании
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or fix outputStream/inputStream according to your real file location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File your_file_name = File.createTempFile("your_file_name", null);
//            String your_file_name = "c:/21.txt";
            OutputStream outputStream = new FileOutputStream(your_file_name);
            InputStream inputStream = new FileInputStream(your_file_name);

            JavaRush javaRush = new JavaRush();
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
            User temp = new User();
            temp.setCountry(User.Country.RUSSIA);
            temp.setFirstName("Alex");
            temp.setLastName("Rudnev");
            temp.setMale(true);
            temp.setBirthDate(new Date());

            javaRush.users.add(temp);
            javaRush.users.add(temp);
            javaRush.users.add(temp);

            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            //check here that javaRush object equals to loadedObject object - проверьте тут, что javaRush и loadedObject равны
            for (int i = 0; i < javaRush.users.size(); i++)
            {
                System.out.println(javaRush.users.get(i).getFirstName() + " " + javaRush.users.get(i).getLastName() + " "
                        + javaRush.users.get(i).getBirthDate() + " " + javaRush.users.get(i).getCountry());
            }
            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод
            PrintWriter writer = new PrintWriter(outputStream);
            String isUsersUse = users.size() > 0 ? "yes" : "no";
            writer.println(isUsersUse);
            if(isUsersUse.equals("yes"))
            {
                for(User a: users){
                    writer.println(a.getFirstName() + " " + a.getLastName() + " " + a.getBirthDate().getTime() + " " + a.isMale() + " " + a.getCountry());
                }
            }
            writer.flush();
            writer.close();
        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            if (reader.ready()){
                if("yes".equals(reader.readLine()))
                {
                    while(reader.ready()){
                        String str = reader.readLine();
                        String[] strArr = str.split(" ");
                        String assName = "";
                        User temp = new User();
                        temp.setFirstName(strArr[0]);
                        temp.setLastName(strArr[1]);
                        temp.setBirthDate(new Date(Long.parseLong(strArr[2])));
                        temp.setMale(Boolean.parseBoolean(strArr[3]));
                        temp.setCountry(User.Country.valueOf(strArr[4]));
                        this.users.add(temp);
                    }
                }
            }
            reader.close();
        }
    }
}