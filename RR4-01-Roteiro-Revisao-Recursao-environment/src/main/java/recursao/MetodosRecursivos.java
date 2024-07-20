package recursao;

public class MetodosRecursivos {

	public int calcularSomaArray(int[] array){
		int result = 0;
		int tamanho = array.length;
		result = calcularSomaArray(array, tamanho);
		
		//[1,2,3,4,5,6,7,8,9,10]
		// TODO ESCREVA AQUI O CÓDIGO (USANDO RECURSAO) PARA CALCULAR A SOMA
		// DOS ELEMENTOS DE UM ARRAY
		return result;
	}

	private int calcularSomaArray(int[] array, int tamanho){
		int result = 0;

		if(tamanho == 1){
			result = array[0];
		}else{
			result = array[tamanho-1];
			result += calcularSomaArray(array, tamanho-1);
		}
		return result;
	}
	public long calcularFatorial(int n) {
		long result = 1;

		if(n == 0){
			result = 1;
		}else{

			result = n* calcularFatorial(n-1);
		}
		// TODO ESCREVA AQUI O CÓDIGO (USANDO RECURSAO) PARA CALCULAR E IMPRIMIR
		// O FATORIAL DO PARAMETRO
		// DE ACORDO COM O QUE FOI MOSTRADO NO EXERCCICIO. OBSERVE QUE SENDO O
		// METODO
		// RECURSIVO, O FATORIAL DOS NUMEROS ANTERIORES TAMBEM VAO SER IMPRESSOS
		return result;
	}

	public int calcularFibonacci(int n) {
		int result = 1;
		if(n==1|| n==2){

		}else{
			result = calcularFibonacci(n-1)+ calcularFibonacci(n-2);
		}
		// TODO ESCREVA AQUI O CÓDIGO (USANDO RECURSAO) PARA CALCULAR E IMPRIMIR
		// O N-ESIMO TERMO
		// DA SEQUENCIA DE FIBONACCI, QUE TEM A SEGUINTE LEI DE FORMACAO: O
		// PRIMEIRO E SEGUNDO NUMEROS
		// DA SEQUENCIA SÃO 1. A PARTIR DO TERCEIRO TERMO, CADA TERMO DA
		// SEQUENCIA É DADO
		// PELA SOMA DOS OUTROS DOIS ANTERIORES. OBSERVE QUE SENDO O METODO
		// RECURSIVO, O FIBONACCI DOS NUMEROS ANTERIORES TAMBEM VAO SER
		// IMPRESSOS
		return result;
	}

	public int countNotNull(Object[] array) {
		int result = 0;
		result = countNotNull(array, 0);
		// TODO IMPLEMENTE AQUI O CODIGO QUE CONTA (USANDO RECURSAO) A
		// QUANTIDADE DE ELEMENTOS NAO NULOS
		// DE UM ARRAY DE OBJETOS RECEBIDO COMO PARAMETRO
		return result;
	}

	private int countNotNull(Object[] array,int index){
		int result = 0;

		if(array[index] != null){
			result++;
		}

		if(index != array.length - 1){ //caso base é o momento que o indice é o do ultimo elemento do array.
			result += countNotNull(array, index+1);
		}

		return result;
	}


	public long potenciaDe2(int expoente) {
		long result = 1;

		if(expoente == 0){

		}else{
			result = 2 * potenciaDe2(expoente-1);
		}
		// TODO IMPLEMENTE (USANDO RECURSAO) O CODIGO PARA PRODUZIR A N-ESIMA
		// POTENCIA
		// DE 2
		return result;
	}

	public double progressaoAritmetica(double termoInicial, double razao, int n) {
		double result = termoInicial;

		if(n==1){

		}else{
			result = progressaoAritmetica(termoInicial, razao, n-1) + razao;
		}
		// TODO IMPLEMENTE SEU CODIGO (USANDO RECURSAO) DE ENCONTRAR O n-ESIMO
		// TERMO
		// DA PROGRESSAO ARITMETICA, DADO O TERMO INICIAL E A RAZAO
		// VOCE NAO PODE USAR A FORMULA QUE CALCULA O N-ESIMO TERMO. DEVE USAR RECURSAO
		return result;
	}

	public double progressaoGeometrica(double termoInicial, double razao, int n) {
		double result = termoInicial;
		if(n==1){

		}else{
			result = progressaoGeometrica(termoInicial, razao, n-1) * razao;
		}
		// TODO IMPLEMENTE SEU CODIGO (USANDO RECURSAO) DE ENCONTRAR O n-ESIMO
		// TERMO
		// DA PROGRESSAO GEOMETRICA, DADO O TERMO INICIAL E A RAZAO
		// VOCE NAO PODE USAR A FORMULA QUE CALCULA O N-ESIMO TERMO. DEVE USAR RECURSAO
		return result;
	}
	
	
}
