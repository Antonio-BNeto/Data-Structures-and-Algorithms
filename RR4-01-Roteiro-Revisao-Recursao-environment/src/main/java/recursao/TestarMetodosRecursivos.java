package recursao;

public class TestarMetodosRecursivos {
	public static void main(String[] args) {
		// preencha esse metodo com codigo para testar a classe MetodosRecursivos.
		MetodosRecursivos metodos = new MetodosRecursivos();
		System.out.println(metodos.calcularFatorial(5)); //esperado 120
		System.out.println(metodos.calcularFatorial(6)); // esperado 720
		System.out.println(metodos.calcularFibonacci(4)); //esperado 3
		System.out.println(metodos.calcularFibonacci(5)); // esperado 5
		System.out.println(metodos.potenciaDe2(3)); // esperado 8
		System.out.println(metodos.potenciaDe2(4)); // esperado 16
		System.out.println(metodos.progressaoAritmetica(1, 2, 3)); // esperado 5
		System.out.println(metodos.progressaoAritmetica(3, 3, 4)); // esperado 12
		int[] numeros = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		System.out.println(metodos.calcularSomaArray(numeros));
		String[] palavras = {null, "9", null, null, "oi", "eai"};
		System.out.println(metodos.countNotNull(palavras));
	}
}
