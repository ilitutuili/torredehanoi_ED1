import java.util.concurrent.TimeUnit;

public class hanoi {

    static long contador; // Contador de movimentos

    // Método recursivo
    public static void resolverHanoi(long n, char origem, char destino, char auxiliar) {
        if (n == 1) {
            contador++;
            return;
        }
        resolverHanoi(n - 1, origem, auxiliar, destino);
        contador++;
        resolverHanoi(n - 1, auxiliar, destino, origem);
    }

    // Método para calcular e formatar o tempo em HH:MM:SS:mm
    public static String formatarTempo(long tempoEmNanos) {
        long millis = TimeUnit.NANOSECONDS.toMillis(tempoEmNanos);
        long horas = millis / 3600000;
        long minutos = (millis % 3600000) / 60000;
        long segundos = (millis % 60000) / 1000;
        long milissegundos = millis % 1000;

        return String.format("%02d:%02d:%02d:%03d", horas, minutos, segundos, milissegundos);
    }

    // Executa uma instância e exibe resultados
    public static void executarInstancia(int discos) {
        contador = 0;
        System.out.println("--------------------------------------------------");
        System.out.println("🔹 Executando instância com " + discos + " discos...");

        long inicio = System.nanoTime();
        resolverHanoi(discos, 'A', 'C', 'B');
        long fim = System.nanoTime();

        long duracao = fim - inicio;
        String tempoFormatado = formatarTempo(duracao);

        System.out.println("✅ Total de movimentos: " + contador);
        System.out.println("🧮 Fórmula teórica (2^n - 1): " + ( (long)Math.pow(2, discos) - 1 ));
        System.out.println("⏱ Tempo gasto: " + tempoFormatado);
        System.out.println("--------------------------------------------------\n");
    }

    public static void main(String[] args) {
        int[] instancias = {1, 10, 20, 30, 40, 41};

        for (int discos : instancias) {
            executarInstancia(discos);
        }
    }
}
