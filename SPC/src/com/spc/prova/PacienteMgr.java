package com.spc.prova;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Comparator;

public class PacienteMgr {

	public static void main(String[] args) {
		List<Paciente> pacientes = new ArrayList<Paciente>();
		Scanner scanner = new Scanner(System.in);
		boolean valida;
		
		
		
		// loop infinito criado para adicionar pacientes na lista até que o nome do
		// paciente venha com "fim"
		while(true) {
			Paciente Paciente = new Paciente();
			System.out.println("Digite o nome do Paciente");
 			Paciente.setNome(scanner.next());
			if(Paciente.getNome().equalsIgnoreCase("fim")) {
				break;
			}
			
			
			// loop para validar o input e garantir funcionamento sem erros
			do {
				System.out.println("Digite o sexo do Paciente (M para Masculino e F para Feminino)");
				if(scanner.hasNext("F") || scanner.hasNext("M")) {
					Paciente.setSexo(scanner.next());
					valida = true;
					
				}else {
					System.out.println("Sexo invalido, favor digitar novamente");
					valida = false;
					scanner.next();
				}
			}while(valida == false);
			
			
			// loop para validar o input e garantir funcionamento sem erros
			do {
				System.out.println("Digite o peso do Paciente");
				if(scanner.hasNextDouble()) {
					Paciente.setPeso(scanner.nextDouble());
					valida = true;
				}else {
					System.out.println("Peso invalido, favor digitar novamente");
					valida = false;
					scanner.next();
				}
			}while(valida == false);
			
			
			// loop para validar o input e garantir funcionamento sem erros
			do {
				System.out.println("Digite a idade do Paciente");
				if(scanner.hasNextInt()) {
					Paciente.setIdade(scanner.nextInt());
					valida = true;
				}else {
					System.out.println("Idade invalida, favor digitar novamente");
					valida = false;
					scanner.next();
				}
			}while(valida == false);
			
			// loop para validar o input e garantir funcionamento sem erros
			do {
				System.out.println("Digite a altura do Paciente");
				if(scanner.hasNextDouble()) {
					Paciente.setAltura(scanner.nextDouble());
					
					valida = true;
				}else {
					System.out.println("Altura invalida, favor digitar novamente");
					valida = false;
					scanner.next();
				}
			}while(valida == false);
			pacientes.add(Paciente);
		}
			
	
		System.out.println("Numero de pacientes = " + pacientes.size());
		System.out.println("Media de idade dos homens = " + getMediaIdadeHomem(pacientes) );
		System.out.println("Quantidade de mulheres com altura entre 1,60 e 1,70 e peso acima de 70kg = " + getMulheres(pacientes));
		System.out.println("Qtd de Pessoas c idade entre 18 e 25 = " + getQtdPessoasFaixaIdade(pacientes));
		System.out.println("Paciente mais velho = " + getPacienteVelho(pacientes));
		System.out.println("Mulher mais baixa = " + getMulherBaixa(pacientes));
	}
	
	// Metodo responsavel por retornar a idade media dos homems
	private static double getMediaIdadeHomem(List<Paciente> pacientes) {
		double mediaIdade = 0;
		int Masc =0;
		for(int i =0; i< pacientes.size(); i++){
			if(pacientes.get(i).getSexo().equalsIgnoreCase("M")) {
				mediaIdade += pacientes.get(i).getIdade();
				Masc++;
			} 
		}	
		
		return mediaIdade/Masc;
		
		
	}
	
	// Metodo responsavel por retornar a qtd de mulheres com + de 70kgs e altura entre
	// 1.6 e 1.7
	private static int getMulheres(List<Paciente> pacientes) {
		int qtdMulheres = 0;
		for(Paciente p : pacientes) {
			if(p.getSexo().equalsIgnoreCase("F") && p.getPeso() > 70 && 
					(p.getAltura() > 1.60 && p.getAltura() < 1.70)) {
				qtdMulheres++;
			}
		}
		return qtdMulheres;
	}
	
	// Metodo responsavel por retornar a qtd de pessoas com + de 18 anos e menos que 25
	private static int getQtdPessoasFaixaIdade(List<Paciente> pacientes) {
		int qtdPessoas = 0;
		for(Paciente p : pacientes) {
			if(p.getIdade() > 18 && p.getIdade() < 25) {
				qtdPessoas++;
			}
		}
		return qtdPessoas;
		
	}
	
	//Metodo responsavel por retornar o paciente mais velho
	private static String getPacienteVelho(List<Paciente> pacientes) {	
		//Ordenar a lista pela idade
		pacientes.sort(Comparator.comparingInt(Paciente::getIdade));
		return pacientes.get(pacientes.size()-1).getNome();
	}
	
	private static String getMulherBaixa(List<Paciente> pacientes) {	
		//Ordena a lista pelo sexo ( no caso todos os femininos no começo) e depois 
		// pela altura
		pacientes.sort(Comparator.comparing(Paciente::getSexo).thenComparingDouble(Paciente::getAltura));
		return pacientes.get(0).getNome();
	}
	
}
