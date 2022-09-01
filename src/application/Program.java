package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Lesson;
import entities.Task;
import entities.Video;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		List<Lesson> list = new ArrayList<Lesson>();

		System.out.print("Quantas aulas tem o curso? ");
		int quantityLesson = sc.nextInt();

		for (int i = 1; i <= quantityLesson; i++) {
			System.out.println();
			System.out.println("Dados da " + i + "a aula:");
			System.out.print("Conteúdo ou tarefa (c/t)? ");
			char type = sc.next().charAt(0);
			System.out.print("Título: ");
			sc.nextLine();
			String title = sc.nextLine();
			if (type == 'c') {
				System.out.print("URL do vídeo: ");
				String url = sc.nextLine();
				System.out.print("Duração em segundos: ");
				int duration = sc.nextInt();
				list.add(new Video(title, url, duration));
			} else {
				System.out.print("Descrição: ");
				String description = sc.nextLine();
				System.out.print("Quantidade de questões: ");
				int quantityQuestions = sc.nextInt();
				list.add(new Task(title, description, quantityQuestions));
			}
		}
		int duration = 0;
		for (Lesson lesson : list) {
			duration += lesson.duration();
		}

		System.out.println();
		System.out.printf("DURAÇÃO TOTAL DO CURSO = %d segundos", duration);
		sc.close();
	}
}
