# pooImpressao


_____________________FUNCIONAMENTO DO SISTEMA______________________

O sistema consiste em um atendimento de caixa que permite ao usuário escolher operações através de um menu interativo. O sistema se comunica com a impressora de cupom fiscal utilizando as funções disponíveis na biblioteca da Elgin, laços de repetição, estruturas de condição e funções personalizadas

_____________________COMO EXECUTAR______________________

> 1. Abrindo o GIT hub

Abra o GitHub

Faça login

Acesse o projeto da pooImpressao

Clique no botão verde <> Code

Clique em Download ZIP para baixar o arquivo do código

Na área de downloads dos seus arquivos procure pela pasta do projeto

Clique na pasta com o botão direito do mouse

Selecione a opção "Extrair tudo..."

> 2. Abrindo o IntelliJ Community

Abra o IntelliJ IDEA

Clique em File > Open

Selecione a pasta do projeto extraida

Aguarde o IntelliJ carregar a pasta

> 3. Configurando o Projeto

Certifique-se de que a biblioteca da Elgin (DLL) esteja devidamente configurada na pasta

Verifique se a classe Main possui o método public static void main(String[] args), que é o ponto de entrada de um programa em Java, para iniciar o programa

> 4. Rodando o Código

Abra a classe Main.java

Clique no ícone de Play ▶ ao lado do método main

O menu do programa será exibido no console

Siga as instruções digitando as opções desejadas

> 5. Iniciando a Impressão

Para realizar qualquer impressão, é obrigatório abrir a conexão com a impressora antes de chamar qualquer função de impressão

No menu do sistema, escolha a opção desejada

A impressaão será realizada, contanto que esteja tudo correto (conexão aberta, caminhos da pasta, etc)

_____________________FUNÇÕES EXPLICADAS NO CÓDIGO______________________

AbreConexaoImpressora()

int AbreConexaoImpressora	( int 	tipo,
const char * 	modelo,
const char * 	conexao,
int 	parametro )
		
> Abre conexão com a impressora.
______________________________________

FechaConexaoImpressora()

int FechaConexaoImpressora	(		)
	
> Fecha conexão com a impressora.

> Finaliza a conexão que foi estabelecida em AbreConexaoImpressora.

> Retorna: O retorno da função é do tipo numérico. 
A função bem sucedida deve retornar 0.
_______________________________________

ImpressaoTexto()

int ImpressaoTexto	( const char * 	dados,
int 	posicao,
int 	stilo,
int 	tamanho 
)	
	
> Envia informações de texto para o buffer da impressora.

> As informações são impressas quando o buffer atinge o limite, quando é executada a
função AvancaPapel ou quando recebe um byte 10 (Line Feed – LF).
Caso nenhuma dessas opções seja executada um próximo comando pode apagar os dados do buffer.

_________________________________________

Corte()

int Corte	( int 	avanco )	

> Realiza o corte do papel.


> Parâmetros:
avanco - Parâmetro numérico que indica o quanto o papel deve avançar antes do corte.
Retorna: Retorno numérico que indica se a operação foi concluída com sucesso.
A função bem sucedida deve retornar 0.
________________________________________

ImpressaoQRCode()

int ImpressaoQRCode	( const char * 	dados,
int 	tamanho,
int 	nivelCorrecao )		
Impressão de QRCode.

> Imprime o código QRCode com possibilidade de variação de tamanho e nível de correção.
_________________________________________

ImpressaoCodigoBarras()

int ImpressaoCodigoBarras	( int 	tipo,
const char * 	dados,
int 	altura,
int 	largura,
int 	HRI )	
	
> Realiza a impressão de código de barras.
_________________________________________


AvancaPapel()

int AvancaPapel	( int 	linhas )	

> Imprime informações no buffer e avança o papel.

> Parâmetros
linhas - Indica o quanto o papel deve avançar.
> Retorna: O retorno é numérico.
A função bem sucedida deve retornar 0.

__________________________________________

AbreGavetaElgin()

int AbreGavetaElgin	(		)	
Abre gavetas Elgin.

> Usa parâmetros padrões para abertura de gavetas Elgin.

> Retorna: O retorno é numérico.
A função bem sucedida deve retornar 0.
__________________________________________


AbreGaveta()

int AbreGaveta	( int 	pino,
int 	ti,
int 	tf )	
	
> Abre gaveta.

> Essa função abre gavetas de acordo com os parâmetros fornecidos.

__________________________________________

SinalSonoro()

int SinalSonoro	( int 	qtd,
int 	tempoInicio,
int 	tempoFim )
		
> Emite sinal sonoro.

> Emite sinal sonoro na impressora. Algumas impressoras não estão habilitadas para emitir sinal sonoro.

___________________________________________

ImprimeXMLSAT()

> Imprime Danfe SAT.

> Essa função recebe o XML de retorno da venda do SAT, valida o conteúdo, constrói o Danfe e realiza a impressão de acordo com a especificação.
___________________________________________

ImprimeXMLCancelamentoSAT()

int ImprimeXMLCancelamentoSAT	( const char * 	dados,
const char * 	assQRCode,
int 	param )	
	
> Imprime Danfe de cancelamento SAT.

> Essa função recebe o XML de retorno da operação de cancelamento e os dados de assinatura do QRCode de venda, valida as informações, constrói o Danfe e realiza impressão de acordo com a especificação.

_____________________GRUPO______________________

Alunos: Pedro, Murilo Zanni, Sophia Santana, João Vitor, Melyssa Pereira - 2TIMB
