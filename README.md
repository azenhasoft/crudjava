# CRUD de usuários em Java

Aplicação de terminal para praticar classes, objetos, listas e entrada de dados em Java. Permite cadastrar, listar, atualizar e excluir usuários durante uma execução.

## Requisitos

JDK instalado, com `javac` e `java` disponíveis no terminal.

## Executar

```bash
git clone https://github.com/azenhasoft/crudjava.git
cd crudjava
javac Main.java Usuario.java
java Main
```

Os arquivos Java ficam na raiz do repositório. Para limpar os arquivos compilados, remova os `.class` gerados localmente.

## Como funciona

Escolha uma opção do menu e siga as instruções. Cada usuário tem um ID inteiro, um nome e um email. O ID deve ser único; nome e email não podem ficar vazios. Se você digitar texto no lugar de um número, o programa pede novamente a entrada. As informações ficam apenas em memória e desaparecem ao encerrar o programa.

```text
1 - Cadastrar usuário
2 - Listar usuários
3 - Atualizar usuário
4 - Excluir usuário
0 - Sair
```

Este é um exercício de CRUD em memória. Ele não usa banco de dados, validação completa de email nem autenticação.

Autor: [Lucas Azenha](https://github.com/azenhasoft).
