// importação de bibliotecas //

import com.sun.jna.Library;
import com.sun.jna.Native;
import java.util.Scanner;
import javax.swing.JFileChooser;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.io.FileInputStream;

// abertura do Main //

public class Main {

    // interface que representa a dll para pegar arquivos para uso na impressora //

    public interface ImpressoraDLL extends Library {

        // caminho completo para a DLL //

        ImpressoraDLL INSTANCE = (ImpressoraDLL) Native.load(
                "C:\\Users\\victor_tavares\\Desktop\\Java-Aluno EM\\E1_Impressora01.dll",
                ImpressoraDLL.class
        );

        // declarações de funções //

        int AbreConexaoImpressora(int tipo, String modelo, String conexao, int param);
        int FechaConexaoImpressora();
        int ImpressaoTexto(String dados, int posicao, int estilo, int tamanho);
        int Corte(int avanco);
        int ImpressaoQRCode(String dados, int tamanho, int nivelCorrecao);
        int ImpressaoCodigoBarras(int tipo, String dados, int altura, int largura, int HRI);
        int AvancaPapel(int linhas);
        int StatusImpressora(int param);
        int AbreGavetaElgin();
        int AbreGaveta(int pino, int ti, int tf);
        int SinalSonoro(int qtd, int tempoInicio, int tempoFim);
        int ModoPagina();
        int LimpaBufferModoPagina();
        int ImprimeModoPagina();
        int ModoPadrao();
        int PosicaoImpressaoHorizontal(int posicao);
        int PosicaoImpressaoVertical(int posicao);
        int ImprimeXMLSAT(String dados, int param);
        int ImprimeXMLCancelamentoSAT(String dados, String assQRCode, int param);
    }

    private static boolean conexaoAberta = false;
    private static int tipo;
    private static String modelo;
    private static String conexao;
    private static int parametro;
    private static final Scanner scanner = new Scanner(System.in);

    private static String capturarEntrada(String mensagem) {
        System.out.print(mensagem);
        return scanner.nextLine();
    }

    // configura a conexão com a impressora //

    public static void configurarConexao() {
        if (!conexaoAberta) {
            System.out.println("Digite o tipo de conexão (ex: 1 para USB, 2 para serial, etc.): ");
            tipo = Integer.parseInt(scanner.nextLine());
            System.out.print("Digite o modelo da impressora: ");
            modelo = scanner.nextLine();
            System.out.print("Digite a conexão (ex: COM3, USB, TCP://IP): ");
            conexao = scanner.nextLine();
            System.out.print("Digite o parâmetro (ex: 0): ");
            parametro = Integer.parseInt(scanner.nextLine());
            System.out.println("Configuração salva com sucesso.");
        } else {
            System.out.println("A conexão já está aberta, feche-a antes de reconfigurar.");
        }
    }

    // abrir a conexãoi com a impressora //

    public static void abrirConexao() {
        if (!conexaoAberta) {
            int retorno = ImpressoraDLL.INSTANCE.AbreConexaoImpressora(tipo, modelo, conexao, parametro);
            if (retorno == 0) {
                conexaoAberta = true;
                System.out.println("Conexão aberta com sucesso.");
            } else {
                System.out.println("Erro ao abrir conexão. Código de erro: " + retorno);
            }
        } else {
            System.out.println("Nenhuma conexão aberta.");
        }
    }

    // fecha a conexão com a impressora //

    public static void fecharConexao() {
        if (conexaoAberta) {
            int retorno = ImpressoraDLL.INSTANCE.FechaConexaoImpressora();
            if (retorno == 0) {
                conexaoAberta = false;
                System.out.println("Conexão fechada com sucesso.");
            } else {
                System.out.println("Erro ao fechar conexão. Código: " + retorno);
            }
        } else {
            System.out.println("Nenhuma conexão aberta.");
        }
    }

    // imprime um texto de teste //

    public static void impressaoTexto() {
        if (conexaoAberta) {
            int retorno = ImpressoraDLL.INSTANCE.ImpressaoTexto("Teste de impressao", 1, 4, 0);

            if (retorno == 0) {
                System.out.println("Impressão realizada com sucesso!");
            } else {
                System.out.println("Erro ao abrir conexão. Código de erro: " + retorno);
            }
        } else {
            System.out.println("Nenhuma conexão aberta.");
        }
    }

    // imprime um QRCode de teste //

    public static void impressaoQRCode() {
        if (conexaoAberta) {
            int retorno = ImpressoraDLL.INSTANCE.ImpressaoQRCode("Teste de impressao", 6, 4);

            if (retorno == 0) {
                System.out.println("Impressão realizada com sucesso!");
            } else {
                System.out.println("Erro ao abrir conexão. Código de erro: " + retorno);
            }
        } else {
            System.out.println("Nenhuma conexão aberta.");
        }
    }

    // Imprime um código de barras //

    public static void impressaoCodigoBarras() {
        if (conexaoAberta) {
            int retorno = ImpressoraDLL.INSTANCE.ImpressaoCodigoBarras(8, "{A012345678912", 100, 2, 3);

            if (retorno == 0) {
                System.out.println("Impressão realizada com sucesso!");
            } else {
                System.out.println("Erro ao abrir conexão. Código de erro: " + retorno);
            }
        } else {
            System.out.println("Nenhuma conexão aberta.");
        }
    }

    // imprime uma nota fiscal //

    public static void ImprimeXMLSAT() {
        if (conexaoAberta) {

            int retorno = ImpressoraDLL.INSTANCE.ImprimeXMLSAT("path=C:\\Users\\victor_tavares\\Desktop\\Java-Aluno EM\\XMLSAT.xml", 0);
            if (retorno == 0) {
                System.out.println("Impressão XMLSAT realizada com sucesso!");
            } else {
                System.out.println("Erro ao abrir conexão. Código de erro: " + retorno);
            }
        } else {
            System.out.println("Nenhuma conexão aberta.");
        }
    }

    // imprime uma nota de cancelamento //

    public static void ImprimeXMLCancelamentoSAT() {
        if (conexaoAberta) {

            int retorno = ImpressoraDLL.INSTANCE.ImprimeXMLCancelamentoSAT("path=C:\\Users\\victor_tavares\\Desktop\\Java-Aluno EM\\CANC_SAT.xml", "Q5DLkpdRijIRGY6YSSNsTWK1TztHL1vD0V1Jc4spo/CEUqICEb9SFy82ym8EhBRZjbh3btsZhF+sjHqEMR159i4agru9x6KsepK/q0E2e5xlU5cv3m1woYfgHyOkWDNcSdMsS6bBh2Bpq6s89yJ9Q6qh/J8YHi306ce9Tqb/drKvN2XdE5noRSS32TAWuaQEVd7u+TrvXlOQsE3fHR1D5f1saUwQLPSdIv01NF6Ny7jZwjCwv1uNDgGZONJdlTJ6p0ccqnZvuE70aHOI09elpjEO6Cd+orI7XHHrFCwhFhAcbalc+ZfO5b/+vkyAHS6CYVFCDtYR9Hi5qgdk31v23w==", 0);
            if (retorno == 0) {
                System.out.println("Impressão XMLSAT realizada com sucesso!");
            } else {
                System.out.println("Erro ao abrir conexão. Código de erro: " + retorno);
            }
        } else {
            System.out.println("Nenhuma conexão aberta.");
        }
    }

    // abre gavetas do tipo elgin //

    public static void abreGavetaElgin() {
        if (conexaoAberta) {
            int retorno = ImpressoraDLL.INSTANCE.AbreGavetaElgin();
            if (retorno == 0) {
                System.out.println("Gaveta Elgin aberta! ");
            } else {
                System.out.println("Erro ao abrir gaveta Elgin. Código de erro: " + retorno);
            }
        } else {
            System.out.println("Nenhuma conexão aberta.");
        }
    }

    // abre gavetas em geral //

    public static void abreGaveta() {
        if (conexaoAberta) {
            int retorno = ImpressoraDLL.INSTANCE.AbreGaveta(1, 5, 10);

            if (retorno == 0) {
                System.out.println("Gaveta aberta! ");
            } else {
                System.out.println("Erro ao abrir gaveta. Código de erro: " + retorno);
            }
        } else {
            System.out.println("Nenhuma conexão aberta.");
        }
    }

    // emite um bip //

    public static void sinalSonoro() {
        if (conexaoAberta) {
            int retorno = ImpressoraDLL.INSTANCE.SinalSonoro(4, 5, 5);
            if (retorno == 0) {
                System.out.println("Sinal sonoro emitido!");
            } else {
                System.out.println("Erro ao emitir sinal sonoro. Código de erro: " + retorno);
            }
        } else {
            System.out.println("Nenhuma conexão aberta.");
        }
    }

    // rotação do código //

    public static void main(String[] args) {

        // menu principal //

        while (true) {
            System.out.println("\n*************************************************");
            System.out.println("**************** MENU IMPRESSORA ****************");
            System.out.println("*************************************************\n");
            System.out.println("1  - Configurar Conexao");
            System.out.println("2  - Abrir Conexao");
            System.out.println("3  - Fechar Conexao");
            System.out.println("4  - Impressão de Texto");
            System.out.println("5  - Impressão de QRCode");
            System.out.println("6  - Impressão de Código de Barras");
            System.out.println("7  - Impressão de XML SAT");
            System.out.println("8  - Impressão de XML Cancelamento SAT");
            System.out.println("9  - Abrir Gaveta Elgin");
            System.out.println("10 - Abrir Gaveta");
            System.out.println("11 - Emitir Sinal Sonoro");
            System.out.println("0  - Sair");

            String escolha = capturarEntrada("\nDigite a opção desejada: ");

            switch (escolha) {

                // chama as funções //

                case "1":
                    configurarConexao();
                    break;
                case "2":
                    abrirConexao();
                    break;
                case "3":
                    fecharConexao();
                    break;
                case "4":
                    impressaoTexto();
                    ImpressoraDLL.INSTANCE.Corte(5);
                    break;
                case "5":
                    impressaoQRCode();
                    ImpressoraDLL.INSTANCE.Corte(5);
                    break;
                case "6":
                    impressaoCodigoBarras();
                    ImpressoraDLL.INSTANCE.Corte(5);
                    break;
                case "7":
                    ImprimeXMLSAT();
                    ImpressoraDLL.INSTANCE.Corte(5);
                    break;
                case "8":
                    ImprimeXMLCancelamentoSAT();
                    ImpressoraDLL.INSTANCE.Corte(5);
                    break;
                case "9":
                    abreGavetaElgin();
                    break;
                case "10":
                    abreGaveta();
                    break;
                case "11":
                    sinalSonoro();
                    break;
                case "0":
                    fecharConexao();
                    System.out.println("Programa encerrado.");
                    return;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }

    private static String lerArquivoComoString(String path) throws IOException {
        FileInputStream fis = new FileInputStream(path);
        byte[] data = fis.readAllBytes();
        fis.close();
        return new String(data, StandardCharsets.UTF_8);
    }

}
