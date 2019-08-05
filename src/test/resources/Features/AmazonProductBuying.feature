# language: pt
# Author: Bruno Henrique
# encoding UTF-8

Funcionalidade: Início de compra na Amazon
	A fim de utilizar os serviços do Amazon, eu realizo a consulta e adiciono produto no carrinho.

Cenário: Realizar início de cadastro com sucesso
    Dado que eu acesse o site da Amazon Brasil
    Quando pesquiso o produto "O senhor do caos"
	    E seleciono um dos itens pesquisados
	    E adiciono no carrinho
    Então ao consultar na sacola o produto será exibido