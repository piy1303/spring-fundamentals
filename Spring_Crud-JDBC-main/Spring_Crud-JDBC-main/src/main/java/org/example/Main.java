
package org.example;

import java.util.Scanner;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("AppConfig.xml")) {

            StudentDao dao = context.getBean("studentDao", StudentDao.class);

            DepartmentDAO cdao = context.getBean("departmentDAO", DepartmentDAO.class);

            System.out.println("Choose '0' to see student info ---- '1' to see course info");

            int val = sc.nextInt();
            sc.nextLine();

            if (val == 1){
                while (true) {
                    System.out.println("1. Insert Course");
                    System.out.println("2. Display Courses");
                    System.out.println("3. Update Course");
                    System.out.println("4. Delete Course");
                    System.out.println("5. Exit");
                    System.out.print("Enter choice: ");

                    int choice = sc.nextInt();
                    sc.nextLine();

                    switch (choice) {

                        case 1:
                            System.out.print("Enter Course ID: ");
                            int id = sc.nextInt();
                            sc.nextLine();

                            System.out.print("Enter Course Name: ");
                            String name = sc.nextLine();

                            System.out.print("Enter Instructor Name: ");
                            String instructor = sc.nextLine();

                            System.out.print("Enter Course Fee: ");
                            int fee = sc.nextInt();
                            sc.nextLine();

                            int inserted = cdao.insert(id, name, instructor, fee);
                            System.out.println(inserted + " course inserted.");
                            break;

                        case 2:
                            System.out.println("ID | Course Name | Instructor | Fee");
                            for (department d : cdao.getAll()) {
                                System.out.println(d);
                            }
                            break;

                        case 3:
                            System.out.print("Enter Course ID to update: ");
                            int updateId = sc.nextInt();
                            sc.nextLine();

                            System.out.print("Enter new Course Name: ");
                            String newName = sc.nextLine();

                            System.out.print("Enter new Instructor Name: ");
                            String newInstructor = sc.nextLine();

                            System.out.print("Enter new Course Fee: ");
                            int newFee = sc.nextInt();
                            sc.nextLine();

                            int updated = cdao.update(
                                    updateId, newName, newInstructor, newFee
                            );
                            System.out.println(updated + " course(s) updated.");
                            break;

                        case 4:
                            System.out.print("Enter Course ID to delete: ");
                            int deleteId = sc.nextInt();

                            int deleted = cdao.delete(deleteId);
                            System.out.println(deleted + " course(s) deleted.");
                            break;

                        case 5:
                            System.out.println("Program ended.");
                            return;

                        default:
                            System.out.println("Invalid choice.");
                    }
                }
            }

            else{
                while (true) {
                    System.out.println("1. Insert Student");
                    System.out.println("2. Display Students");
                    System.out.println("3. Update Student");
                    System.out.println("4. Delete Student");
                    System.out.println("5. Exit");
                    System.out.print("Enter choice: ");

                    int choice = sc.nextInt();
                    sc.nextLine();

                    switch (choice) {

                        case 1:
                            System.out.print("Enter StdID: ");
                            int id = sc.nextInt();
                            sc.nextLine();

                            System.out.print("Enter StdName: ");
                            String name = sc.nextLine();

                            System.out.print("Enter Address: ");
                            String Address = sc.nextLine();

                            System.out.print("Enter number: ");
                            String number = sc.nextLine();

                            System.out.print("Enter department: ");
                            String department = sc.nextLine();

                            int inserted = dao.insert(id, name, Address,number,department);
                            System.out.println(
                                    inserted + " row inserted."
                            );
                            break;

                        case 2:
                            System.out.println("ID | NAME | Address | number | department");
                            for (Student s : dao.getAll()) {
                                System.out.println(s);
                            }
                            break;

                        case 3:
                            System.out.print("Enter ID to update: ");
                            int updateId = sc.nextInt();
                            sc.nextLine();

                            System.out.print("Enter new name: ");
                            String newName = sc.nextLine();

                            System.out.print("Enter new Address: ");
                            String address = sc.nextLine();

                            System.out.print("Enter new number: ");
                            String numb = sc.nextLine();

                            System.out.print("Enter new department: ");
                            String dpt = sc.nextLine();

                            int updated =
                                    dao.update(updateId, newName, address,numb,dpt);

                            System.out.println(
                                    updated + " row(s) updated."
                            );
                            break;

                        case 4:
                            System.out.print("Enter ID to delete: ");
                            int deleteId = sc.nextInt();

                            int deleted = dao.delete(deleteId);

                            System.out.println(
                                    deleted + " row(s) deleted."
                            );
                            break;

                        case 5:
                            System.out.print("Enter Student ID to find: ");
                            int findId = sc.nextInt();

                            Student s = dao.findById(findId);

                            System.out.println("ID | NAME | Address | number | department");
                            System.out.println(s);
                            break;

                        case 6:
                            System.out.println("Program ended.");
                            return;

                        default:
                            System.out.println("Invalid choice.");
                    }
                }
            }




        }
    }
}
