# pooImpressao

 ARQUIVO README - Trabalho de P.O.O.


_____________________FUNCIONAMENTO DO SISTEMA______________________

O sistema consiste em um atendimento de caixa que permite ao usuário escolher operações através de um menu interativo. O sistema se comunica com a impressora de cupom fiscal utilizando as funções disponíveis na biblioteca da Elgin, laços de repetição, estruturas de condição e funções personalizadas. 

______________________________________________________________________________________________________________________________________


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


______________________________________________________________________________________________________________________________________


Alunos: Pedro, Murilo Zanni, Sophia Santana, João Vitor, Melyssa Pereira - 2TIMB

Professor: Richard Spanhol
