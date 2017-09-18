package com.igorsinchuk.javapro.Module1.TextConteiner;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.lang.reflect.Field;

public class ContainAndSave {
    public static void main(String[] args) {
        Container obj = new Container();

        Class<?> cls = Container.class;
        if (cls.isAnnotationPresent(SaveTo.class)) {
            SaveTo annotation = cls.getAnnotation(SaveTo.class);

            try (FileOutputStream write = new FileOutputStream(annotation.path());
                 ByteArrayOutputStream bos = new ByteArrayOutputStream();
                 DataOutputStream dos = new DataOutputStream(bos)) {

                StringBuilder buf = new StringBuilder();
                Field[] fields = cls.getDeclaredFields();
                for (Field field : fields) {
                    Class<?> fieldType = field.getType();
                    if (fieldType.getName().equals("java.lang.String")) {
                        buf.append("Field \"" + field.getName() + "\" = ");
                        buf.append(field.get(obj) + ";\r\n");
                    }
                }
                dos.writeUTF(buf.toString());
                System.out.println(buf.toString());
                byte[] byteBuff = bos.toByteArray();
                write.write(byteBuff);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
