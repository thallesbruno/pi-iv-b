# PI-IV-B — Aplicações Cliente-Servidor em Java

Projeto didático desenvolvido em sala para estudar comunicação entre cliente e servidor por sockets TCP. O repositório reúne a implementação em Java, os slides e o diagrama da aula 3 de Desenvolvimento de Software Cliente-Servidor.

## Estrutura do repositório

```text
PI-IV-B/
├── src/
│   └── main/
│       └── java/
│           ├── Cliente.java
│           └── Servidor.java
├── docs/
│   ├── slides/
│   │   └── Aplicacoes_Cliente_Servidor.pdf
│   └── diagramas/
│       └── aula-03-software-cliente-servidor.excalidraw
├── .gitignore
└── README.md
```

- [Cliente.java](src/main/java/Cliente.java): conecta ao servidor, envia mensagens digitadas no terminal e exibe as respostas.
- [Servidor.java](src/main/java/Servidor.java): aguarda uma conexão e responde às mensagens recebidas.
- [Slides da aula — Aplicações Cliente-Servidor](docs/slides/Aplicacoes_Cliente_Servidor.pdf): apresentação sobre o modelo cliente-servidor, sockets e a demonstração em Java.
- [Diagrama e anotações da aula 3](docs/diagramas/aula-03-software-cliente-servidor.excalidraw): arquivo editável, que pode ser importado no Excalidraw ou aberto em um editor compatível.

## Como funciona

O servidor escuta na porta TCP `5052`. O cliente se conecta a `localhost:5052` e envia uma mensagem por linha. Para cada mensagem, o servidor devolve o texto em letras maiúsculas.

Ao enviar `SAIR` (sem diferenciar maiúsculas de minúsculas), o servidor responde `TCHAU` e ambos encerram a conexão e a execução.

## Requisitos

- JDK 8 ou superior, com os comandos `java` e `javac` disponíveis no terminal.
- Dois terminais: um para o servidor e outro para o cliente.
- Porta `5052` livre na máquina.

A aplicação usa apenas a biblioteca padrão do Java, sem dependências externas. A compilação é feita diretamente com `javac`.

## Compilar

Na pasta raiz do repositório, execute:

```sh
mkdir -p build/classes
javac -encoding UTF-8 -d build/classes src/main/java/Cliente.java src/main/java/Servidor.java
```

Os comandos acima usam um terminal Bash (Linux, macOS ou Git Bash). No PowerShell, substitua a primeira linha por `New-Item -ItemType Directory -Force build/classes`.

Os arquivos `.class` ficam em `build/classes`, pasta ignorada pelo Git.

## Executar

1. No primeiro terminal, a partir da raiz do repositório, inicie o servidor:

   ```sh
   java -cp build/classes Servidor
   ```

   A mensagem `Aguardando cliente na porta 5052...` indica o início da execução.

2. No segundo terminal, também na raiz do repositório, inicie o cliente:

   ```sh
   java -cp build/classes Cliente
   ```

3. Digite mensagens no terminal do cliente. Exemplo:

   ```text
   > Olá, servidor!
   Servidor: OLÁ, SERVIDOR!
   > SAIR
   Servidor: TCHAU
   ```

Para uma nova sessão, inicie novamente o servidor e depois o cliente.

## Escopo da atividade

Esta implementação atende um único cliente por execução. O endereço e a porta estão definidos no código, e as mensagens são transmitidas em texto simples, sem autenticação ou criptografia. O objetivo é demonstrar o uso de `Socket`, `ServerSocket` e fluxos de entrada e saída.

Os fontes foram preservados conforme a atividade em sala. Concorrência, protocolos mais elaborados e interface gráfica são temas de evolução apresentados nos slides, ainda não implementados neste projeto.

## Problemas comuns

- **`java` ou `javac` não encontrado:** confira se o JDK está instalado e se a pasta de executáveis está no `PATH`.
- **`Connection refused`:** inicie o servidor antes do cliente e confirme que ele continua em execução.
- **`Address already in use`:** a porta `5052` está ocupada; encerre a instância anterior do servidor ou ajuste a porta nos dois arquivos Java e recompile.
- **Classe principal não encontrada:** execute os comandos na raiz do repositório e confira se a compilação gerou os arquivos em `build/classes`.
