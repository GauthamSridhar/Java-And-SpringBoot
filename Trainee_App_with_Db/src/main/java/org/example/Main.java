package org.example;

import org.example.Service.TraineeService;
import org.example.Service.TraineeServiceImpl;
import org.example.configuration.TraineeAppConfig;
import org.example.model.Trainee;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ApplicationContext context=new AnnotationConfigApplicationContext(TraineeAppConfig.class);

        TraineeService traineeService= context.getBean(TraineeServiceImpl.class);

        String name;
        String loc;
        int year, mnt, day;
        Scanner scanner = new Scanner(System.in);
        int ch;
        do {
            System.out.println("\nSelect Operation You Want To Perform: ");
            System.out.println("1->INSERT A RECORD\n2->GET ALL RECORDS\n3->GET RECORD BY ID\n4->DELETE RECORD BY ID\n5->EXIT");
            System.out.println("CHOICE-> ");
            ch = scanner.nextInt();
            scanner.nextLine();
            switch (ch) {
                case 1: {
                    System.out.println("Enter name: ");
                    name = scanner.nextLine();
                    System.out.println("Enter Location: ");
                    loc = scanner.nextLine();
                    System.out.println("Enter Year: ");
                    year = scanner.nextInt();
                    System.out.println("Enter Month: ");
                    mnt = scanner.nextInt();
                    System.out.println("Enter Day: ");
                    day = scanner.nextInt();
                    Trainee trainee = new Trainee(0, name, loc, LocalDate.of(year, mnt, day));
                    traineeService.saveTrainee(trainee);
                    break;

                }
                case 2: {
                    traineeService.getAllTrainees().forEach(t -> System.out.println(t));
                    break;

                }
                case 3: {
                    System.out.println("ENTER ID YOU WANT TO SEARCH-> ");
                    int id = scanner.nextInt();
                    System.out.println(traineeService.getTraineeById(id));
                    break;
                }
                case 4: {
                    System.out.println("ENTER ID YOU WANT TO DELETE-> ");
                    int id = scanner.nextInt();
                    traineeService.deleteTraineeById(id);
                }
                case 5: {
                    System.out.println("EXITED SUCCESSFULLY!!!!");
                    break;
                }
                default:
                    break;
            }
        } while (ch > 0 && ch <5);
//


    }
}