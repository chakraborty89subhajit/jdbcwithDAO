package org.example;

public class TestMain {
    public static void main(String args[]){
        StudentJDBCDAO student= new StudentJDBCDAO();
        StudentBean monu=new StudentBean();
       // monu.setLastName("malhotra");
       // monu.setFirstName("monu");
       // monu.setAge(31);
       // student.add(monu);
       // monu.setLastName("kumar");
       // monu.setFirstName("monu");//FirstName should be same
       // monu.setAge(31);
        //student.update(monu);
        //student.delete("monu");
        student.findAll();

    }
}
