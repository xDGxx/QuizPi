/* **************************************************************** */
/*  Centro Universitario Senac
/*  TADS - 1o Semestre de 2024
/* **************************************************************** */

package QuizPi;

import java.util.Scanner;

public class QuizPi {

    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String PURPLE = "\u001B[35m";
    public static final String BOLD_RED = "\u001B[1;31m";
    public static final String BOLD_GREEN = "\u001B[1;32m";
    public static final String BOLD_BLUE = "\u001B[1;34m";


    static String mensagemCorreta = BOLD_GREEN + "Parabéns! Você escolheu a alternativa correta." + RESET;
    static String mensagemErrada = BOLD_RED + "Desculpe, você escolheu a alternativa errada." + RESET;
    private static Object nome;

    public static void nomeJogador() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n===================================================\n");
        System.out.println("Olá participante, tudo bem?\n");
        System.out.println("Seja muito bem-vindo ao nosso Quiz: *INTELIGÊNCIA ARTIFICIAL - O NOVO NORMAL*\n");
        System.out.println("Estamos muito felizes de ter você por aqui! Esperamos que o conteúdo desse quiz possa contribuir em seus estudos e entendimento sobre a IA, a tecnologia do momento\n");
        System.out.println("Para começarmos, digite seu nome: ");
        nome = scanner.nextLine();

        while (nome.equals("")) {
            System.err.println("Nome inválido. Por favor, digite seu nome novamente:");
            nome = scanner.nextLine();
        }
    }

    public static void comeco() {
        Scanner scanner = new Scanner(System.in);
        int proxtela = 0;
        boolean validInput = false;
        do {
            System.out.println("\n===================================================\n");
            System.out.println("Seja muito bem-vindo, " + GREEN + nome + RESET + ".\n");
            System.out.println("Antes de darmos início ao quiz, vamos falar de como ele funciona, já que não se trata de um Quiz chato e normal, e sim de um interativo e divertido!\n");
            System.out.println("Proxima tela [1]");

            // Verifica se a entrada é um número inteiro
            if (scanner.hasNextInt()) {
                proxtela = scanner.nextInt();
                if (proxtela == 1) {
                    validInput = true;
                } else {
                    System.err.println("\nOpcao Invalida! Selecione novamente.");
                }
            } else {
                // Caso a entrada não seja um número, exibe mensagem de erro
                System.err.println("\nOpcao Invalida! Selecione novamente.");
                scanner.next(); // Consome a entrada inválida
            }
        } while (!validInput);

    }

    public static void regras() {
        Scanner scanner = new Scanner(System.in);
        int proxtela = 0;
        boolean validInput = false;

        do {
            System.out.println("\n===================================================\n");
            System.out.println(YELLOW + " * REGRAS * \n" + RESET);
            System.out.println(" • O jogador possui x números de vida, dependendo do modo de jogo!");
            System.out.println(" • A cada erro, você perde 1 vida, então tome cuidado, pois ao chegar a 0 vidas é game over.");
            System.out.println(" • A cada acerto, além de passar para a próxima pergunta, você ganha pontos e moedas.");
            System.out.println(" • Você pode trocar suas moedas por: Dicas - Vida Extra - NextQuestion - Eliminar Alternativa.");
            System.out.println(" • E tem mais! A cada questão acertada, você libera uma curiosidade sobre o mundo da tecnologia!\n");
            System.out.println("Proxima tela [1]");

            // Verifica se a entrada é um número inteiro
            if (scanner.hasNextInt()) {
                proxtela = scanner.nextInt();
                if (proxtela == 1) {
                    validInput = true;
                } else {
                    System.err.println("\nOpção Inválida! Selecione novamente.");
                }
            } else {
                // Caso a entrada não seja um número, exibe mensagem de erro
                System.err.println("\nOpção Inválida! Selecione novamente.");
                scanner.next(); // Consome a entrada inválida
            }
        } while (!validInput);
    }

    public static int mododejogo() {
        Scanner scanner = new Scanner(System.in);
        int Dificuldade = 0;
        boolean validInput = false;

        do {
            System.out.println("\n===================================================\n");
            System.out.println("Agora chegou o momento de decidir a dificuldade do Quiz");
            System.out.println("Escolha o nível de dificuldade:\n");
            System.out.println("Digite: [1] Fácil | [2] Médio | [3] Difícil\n");
            System.out.print("Escolha: ");

            if (scanner.hasNextInt()) {
                Dificuldade = scanner.nextInt();
                if (Dificuldade == 1 || Dificuldade == 2 || Dificuldade == 3) {
                    validInput = true;
                } else {
                    System.err.println("Opção inválida! Por favor, escolha novamente.\n");
                }
            } else {
                System.err.println("Opção inválida! Por favor, escolha novamente.\n");
                scanner.next(); // Consome a entrada inválida
            }
        } while (!validInput);

        return Dificuldade;
    }

    public static String NomeDaDificuldade(int Dificuldade) {
        String dificuldade_Nome;
        switch (Dificuldade) {
            case 1:
                dificuldade_Nome = "Fácil";
                break;
            case 2:
                dificuldade_Nome = "Médio";
                break;
            case 3:
                dificuldade_Nome = "Difícil";
                break;
            default:
                dificuldade_Nome = "Desconhecido";
        }
        return dificuldade_Nome;
    }

    public static int[] parametros(int Dificuldade) {
        int[] vetor = new int[7];
        switch (Dificuldade) {
            case 1:
                vetor[0] = 10; // GANHO DE PONTOS - MODO FÁCIL
                vetor[1] = 20; // GANHO DE MOEDA - MODO FÁCIL
                vetor[2] = 5;  // VIDAS DISPONÍVEIS - MODO FÁCIL
                vetor[3] = 15; // VALOR DA DICA - MODO FÁCIL
                vetor[4] = 25; // VALOR DE ELIMINAR QUESTÃO - MODO FÁCIL
                vetor[5] = 35; // VALOR DO NEXT QUESTION - MODO FÁCIL
                vetor[6] = 45; // VALOR DA VIDA - MODO FÁCIL
                break;
            case 2:
                vetor[0] = 25; // GANHO DE PONTOS - MODO MÉDIO
                vetor[1] = 15; // GANHO DE MOEDA - MODO MÉDIO
                vetor[2] = 3;  // VIDAS DISPONÍVEIS - MODO MÉDIO
                vetor[3] = 15; // VALOR DA DICA - MODO MÉDIO
                vetor[4] = 25; // VALOR DE ELIMINAR QUESTÃO - MODO MÉDIO
                vetor[5] = 35; // VALOR DO NEXT QUESTION - MODO MÉDIO
                vetor[6] = 45; // VALOR DA VIDA - MODO MÉDIO
                break;
            case 3:
                vetor[0] = 50; // GANHO DE PONTOS - MODO DIFÍCIL
                vetor[1] = 10; // GANHO DE MOEDA - MODO DIFÍCIL
                vetor[2] = 1;  // VIDAS DISPONÍVEIS - MODO DIFÍCIL
                vetor[3] = 15; // VALOR DA DICA - MODO DIFÍCIL
                vetor[4] = 25; // VALOR DE ELIMINAR QUESTÃO - MODO DIFÍCIL
                vetor[5] = 35; // VALOR DO NEXT QUESTION - MODO DIFÍCIL
                vetor[6] = 45; // VALOR DA VIDA - MODO DIFÍCIL
                break;
        }
        return vetor;
    }

    public static int confirmar(int[] vetor, int continuar, String dificuldade_Nome) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n===================================================\n");
        System.out.println("Você selecionou o nível: " + dificuldade_Nome);
        System.out.println(YELLOW + "\nEste modo de jogo possui as seguintes regras:\n" + RESET);
        System.out.println(GREEN + "* GANHOS *\n" + RESET);
        System.out.println("Ganho de pontos a cada acerto: " + vetor[0]);
        System.out.println("Ganho de moedas a cada acerto: " + vetor[1]);
        System.out.println("Quantidade de vidas: " + vetor[2]);
        System.out.println("    ");
        System.out.println(RED + "* CUSTOS *\n" + RESET);
        System.out.println("Dicas: " + vetor[3] + " moedas");
        System.out.println("Eliminar uma alternativa: " + vetor[4] + " moedas");
        System.out.println("NextQuestion: " + vetor[5] + " moedas");
        System.out.println("Vida extra: " + vetor[6]);

        boolean validInput = false;
        do {
            System.out.println("\nDeseja continuar?");
            System.out.println("[1] Sim  | [2] Não\n");
            System.out.print("Escolha: ");
            if (scanner.hasNextInt()) {
                continuar = scanner.nextInt();
                if (continuar == 1 || continuar == 2) {
                    validInput = true;
                } else {
                    System.err.println("Opção inválida! Por favor, escolha novamente.\n");
                    //System.out.println("\n===================================================\n");
                }
            } else {
                System.err.println("Opção inválida! Por favor, escolha novamente.\n");
                //System.out.println("\n===================================================\n");
                scanner.next();
            }
        } while (!validInput);

        return continuar;
    }

    public static int[] EscolhendoModo() {
        int Dificuldade;
        String dificuldade_Nome;
        int continuar;
        int[] vetor;
        do {
            Dificuldade = mododejogo();
            dificuldade_Nome = NomeDaDificuldade(Dificuldade);
            vetor = parametros(Dificuldade);
            continuar = confirmar(vetor, 0, dificuldade_Nome);
        } while (continuar != 1);
        return vetor;
    }

    public static int[] EstoqueGame(int[] vetor) {
        int[] GuardandoGame = new int[7];
        GuardandoGame[0] = 0;       // PONTOS
        GuardandoGame[1] = 0;       // MOEDAS
        GuardandoGame[2] = vetor[2];// VIDAS
        GuardandoGame[3] = 0;       // DICAS
        GuardandoGame[4] = 0;       // ELIMINAR ALTERNATIVA
        GuardandoGame[5] = 0;       // NEXTQUESTION
        GuardandoGame[6] = 0;       // AUXILIAR PARA O NEXTQUESTION
        return GuardandoGame;
    }

    public static void mostra(int[] GuardandoGame) {
        System.out.println("    ");
        System.out.println(BOLD_BLUE + "*  *  *  *  *  *" + RESET);
        System.out.println("  Pontos: " + GuardandoGame[0]);
        System.out.println("  Moedas: " + GuardandoGame[1]);
        System.out.println("  Vidas: " + GuardandoGame[2]);
        System.out.println(BOLD_BLUE + "*  *  *  *  *  *\n" + RESET);
    }

    public static String EnunciadoPergunta1() {
        Scanner scanner = new Scanner(System.in);
        String alternativa;
        do {
            System.out.println("\nO que é a Inteligência Artificial?\n");
            System.out.println("A. A área que busca desvendar a mente humana e recria-la nas máquinas por meio de algoritmos e sistemas.");
            System.out.println("B. A área que busca reproduzir nas máquinas por meio de algoritmos e sistemas, algumas funções cognitivas humanas.");
            System.out.println("C. A área que busca decifrar o código genético humano e replicá-lo nas máquinas por meio de algoritmos e sistemas.\n");
            System.out.println("L. Loja");
            System.out.println("I. Inventário\n");
            System.out.print("Escolha: ");
            alternativa = scanner.nextLine();

            if (!alternativa.equalsIgnoreCase("a")
                    && !alternativa.equalsIgnoreCase("b")
                    && !alternativa.equalsIgnoreCase("c")
                    && !alternativa.equalsIgnoreCase("i")
                    && !alternativa.equalsIgnoreCase("l")) {
                System.err.println("Opção Inválida! Selecione novamente.\n");
            }
        } while (!alternativa.equalsIgnoreCase("a")
                && !alternativa.equalsIgnoreCase("b")
                && !alternativa.equalsIgnoreCase("c")
                && !alternativa.equalsIgnoreCase("l")
                && !alternativa.equalsIgnoreCase("i"));

        return alternativa;
    }


    public static int resposta1(String alternativa) {
        int resp;
        if (alternativa.equalsIgnoreCase("a")) {
            System.out.println("\n* RESPOSTA *\n");
            System.out.println(mensagemErrada);
            System.out.println(RED + "A Inteligência Artificial realmente busca algo na mente humana, porém não é desvendar e sim simula-lá nas máquinas. A mente humana por si só é muito complexa, única e abrangente, algo bastante improvável de se recriar, apenas 'simular'.\n" + RESET);
            System.out.println(BOLD_GREEN + "A alternativa correta é a alternativa B.\n"+ RESET + GREEN + "inteligência artificial busca reproduzir nas máquinas por meio de algoritmos e sistemas, algumas funções cognitivas humanas, como por exemplo: A capacidade de raciocínio, tomada de decisão e aprendizado contínuo.\n" + RESET);
            resp = 0;
        } else if (alternativa.equalsIgnoreCase("b")) {
            System.out.println("* RESPOSTA *\n");
            System.out.println(mensagemCorreta);
            System.out.println(GREEN + "A inteligência artificial busca reproduzir nas máquinas por meio de algoritmos e sistemas, algumas funções cognitivas humanas, como por exemplo: A capacidade de raciocínio, tomada de decisão e aprendizado contínuo.\n" + RESET);
            System.out.println("E como prêmio você acaba de desbloquear uma curiosidade.");
            System.out.println(YELLOW + "Curiosidade:"+ RESET + " Você sabia que o primeiro computador digital eletrônico pesava cerca de incríveis 30 toneladas, contendo impressionantes 180 metros quadrados. O famoso ENIAC!\n");
            resp = 1;
        } else if (alternativa.equalsIgnoreCase("c")) {
            System.out.println("* RESPOSTA *\n");
            System.out.println(mensagemErrada);
            System.out.println(RED + "O projeto 'Genoma Humano' foi lançado em 1989 e teve seu fim em 2003, com o foco em decifrar o código humano, conseguindo desvendar incríveis 92% de nosso código genético, entretanto este não é o foco em geral da IA.\n" + RESET);
            System.out.println(BOLD_GREEN + "A alternativa correta é a alternativa B.\n" + RESET +  GREEN + "A inteligência artificial busca reproduzir nas máquinas por meio de algoritmos e sistemas, algumas funções cognitivas humanas, como por exemplo: A capacidade de raciocínio, tomada de decisão e aprendizado contínuo.\n" + RESET);
            resp = 0;
        } else {
            resp = -1; // Caso de "Loja" ou "Inventário"
        }
        return resp;
    }

    public static String EnunciadoPergunta2() {
        Scanner scanner = new Scanner(System.in);
        String alternativa;

        do {
            System.out.println("\nQuando nasceu a ideia de inteligência artificial?\n");
            System.out.println("A. Em meados de 1950, com a pesquisa pioneira de Alan Turing, a famosa *Computing Machinery and Intelligence*");
            System.out.println("B. Em 1956, com a conferência de Dartmouth, onde o termo *inteligência artificial* foi oficialmente criado");
            System.out.println("C. Com a ideia do *Super computador de Botvinnik*, em 1960\n");
            System.out.println("L. Loja");
            System.out.println("I. Inventário\n");
            System.out.print("Escolha: ");
            alternativa = scanner.nextLine();

            if (!alternativa.equalsIgnoreCase("a")
                    && !alternativa.equalsIgnoreCase("b")
                    && !alternativa.equalsIgnoreCase("c")
                    && !alternativa.equalsIgnoreCase("i")
                    && !alternativa.equalsIgnoreCase("l")) {
                System.err.println("Opção Inválida! Selecione novamente.\n");
            }
        } while (!alternativa.equalsIgnoreCase("a")
                && !alternativa.equalsIgnoreCase("b")
                && !alternativa.equalsIgnoreCase("c")
                && !alternativa.equalsIgnoreCase("l")
                && !alternativa.equalsIgnoreCase("i"));

        return alternativa;
    }

    public static int resposta2(String alternativa) {
        int resp;

        if (alternativa.equalsIgnoreCase("a")) {
            System.out.println("\n* RESPOSTA *\n");
            System.out.println(mensagemCorreta);
            System.out.println(GREEN + "Um dos pioneiros na inteligência artificial antes mesmo de seu termo ter sido inventado. Alan Turing, com a criação de um artigo que explorava a possibilidade de uma máquina conseguir ser instruída a pensar, aprender e utilizar de sua própria inteligência para resolver problemas, igual a um humano.\n" + RESET);
            System.out.println("E como prêmio você acaba de desbloquear uma curiosidade.");
            System.out.println(YELLOW + "Curiosidade:"+ RESET + "Você sabia que Alan Turing é conhecido como o pai da computação? Ele foi o inventor do famoso Teste de Turing, um experimento que avalia a capacidade de uma máquina de exibir comportamento inteligente que seja equivalente ao de um ser humano, ou seja, para saber se um computador pode se passar por um ser humano!\n");
            resp = 1;
        } else if (alternativa.equalsIgnoreCase("b")) {
            System.out.println("\n* RESPOSTA *\n");
            System.out.println(mensagemErrada);
            System.out.println(RED  + "Incorreto. Organizada por John McCarthy, Marvin Minsky, Nathaniel Rochester e Claude Shannon, a conferência de Dartmouth tinha como objetivo explorar a hipótese de que uma máquina pode ser programada para aprender a pensar como um humano. Apesar de tudo isso, este não foi o primeiro registro da ideia de Inteligência artificial, porém foi da criação do termo.\n" + RESET);
            System.out.println(BOLD_GREEN + "A alternativa correta é a alternativa A.\n" + RESET +  GREEN + "Alan Turing, um dos pioneiros na inteligência artificial antes mesmo de seu termo ter sido inventado, com a criação de um artigo que explorava a possibilidade de uma máquina conseguir ser instruída a pensar, aprender e utilizar de sua própria inteligência para resolver problemas, igual a um humano.\n" + RESET);
            resp = 0;
        } else if (alternativa.equalsIgnoreCase("c")) {
            System.out.println("\n* RESPOSTA *\n");
            System.out.println(mensagemErrada);
            System.out.println(RED + "Incorreto. O Campeão mundial de xadrez Botvinnik tinha um projeto, o supercomputador Botvinnik! Seu objetivo era criar um programa de xadrez com a capacidade de reproduzir os processos do cérebro humano, porém essa ideia surgiu em 1960, assim não sendo a primeira.\n" + RESET);
            System.out.println(BOLD_GREEN + "A alternativa correta é a alternativa A.\n" + RESET +  GREEN + "Alan Turing, um dos pioneiros na inteligência artificial antes mesmo de seu termo ter sido inventado, com a criação de um artigo que explorava a possibilidade de uma máquina conseguir ser instruída a pensar, aprender e utilizar de sua própria inteligência para resolver problemas, igual a um humano.\n" + RESET);
            resp = 0;
        } else {
            resp = -1; // Caso de "Loja" ou "Inventário"
        }

        return resp;
    }

    public static String EnunciadoPergunta3() {
        Scanner scanner = new Scanner(System.in);
        String alternativa;

        do {
            System.out.println("\nQual foi a primeira conferência voltada para Inteligência Artificial?\n");
            System.out.println("A. A WWDC (Apple Worldwide Developers Conference");
            System.out.println("B. A International Conference on Machine Learning");
            System.out.println("C. A conferência de Dartmouth\n");
            System.out.println("L. Loja");
            System.out.println("I. Inventário\n");
            System.out.print("Escolha: ");
            alternativa = scanner.nextLine();

            if (!alternativa.equalsIgnoreCase("a")
                    && !alternativa.equalsIgnoreCase("b")
                    && !alternativa.equalsIgnoreCase("c")
                    && !alternativa.equalsIgnoreCase("i")
                    && !alternativa.equalsIgnoreCase("l")) {
                System.err.println("Opção Inválida! Selecione novamente.\n");
            }
        } while (!alternativa.equalsIgnoreCase("a")
                && !alternativa.equalsIgnoreCase("b")
                && !alternativa.equalsIgnoreCase("c")
                && !alternativa.equalsIgnoreCase("l")
                && !alternativa.equalsIgnoreCase("i"));

        return alternativa;
    }

    public static int resposta3(String alternativa) {
        int resp;

        if (alternativa.equalsIgnoreCase("a")) {
            System.out.println("\n* RESPOSTA *\n");
            System.out.println(mensagemErrada);
            System.out.println(RED + "A WWDC (Apple Worldwide Developers Conference) é organizada pela Apple, sendo um evento anual voltado para desenvolvedores de software, onde a empresa revela as últimas atualizações em seus sistemas operacionais e apresenta novas ferramentas e tecnologias para desenvolvedores.\n" + RESET);
            System.out.println(BOLD_GREEN + "A alternativa correta é a alternativa C.\n"+ RESET + GREEN +"A famosa conferência de Dartmouth, realizada em 1956 com o intuito de explorar a hipótese de que 'toda característica do aprendizado ou qualquer outra característica da inteligência pode, em princípio, ser tão precisamente descrita, que uma máquina pode ser feita para simulá-la', ou seja, uma máquina pode ser programada a aprender a pensar como um humano. Vale lembrar que foi nessa conferência onde o termo 'Inteligência Artificial' foi criado.\n" + RESET);
            resp = 0;
        } else if (alternativa.equalsIgnoreCase("b")) {
            System.out.println("\n* RESPOSTA *\n");
            System.out.println(mensagemErrada);
            System.out.println(RED + "A International Conference on Machine Learning é uma das principais conferências acadêmicas voltadas para machine learning. Sendo realizada anualmente reunindo pesquisadores, acadêmicos e profissionais de todo o mundo para apresentar e discutir os avanços mais recentes da tecnologia, contudo por mais que seja uma conferência voltada especialmente para a área, entretanto ela não foi a primeira.\n" + RESET);
            System.out.println(BOLD_GREEN + "A alternativa correta é a alternativa C.\n" + RESET +  GREEN + "A famosa conferência de Dartmouth, realizada em 1956 com o intuito de explorar a hipótese de que 'toda característica do aprendizado ou qualquer outra característica da inteligência pode, em princípio, ser tão precisamente descrita, que uma máquina pode ser feita para simulá-la', ou seja, uma máquina pode ser programada a aprender a pensar como um humano. Vale lembrar que foi nessa conferência onde o termo 'Inteligência Artificial' foi criado.\n" + RESET);
            resp = 0;
        } else if (alternativa.equalsIgnoreCase("c")) {
            System.out.println("\n* RESPOSTA *\n");
            System.out.println(mensagemCorreta);
            System.out.println(GREEN + "A famosa conferência de Dartmouth, realizada em 1956 com o intuito de explorar a hipótese de que 'toda característica do aprendizado ou qualquer outra característica da inteligência pode, em princípio, ser tão precisamente descrita que uma máquina pode ser feita para simulá-la', ou seja, uma máquina pode ser programada a aprender e pensar como um humano. Vale lembrar que foi nessa conferência onde o termo 'Inteligência Artificial' foi criado.\n" + RESET);
            System.out.println("E como prêmio você acaba de desbloquear uma curiosidade.");
            System.out.println(YELLOW + "Curiosidade:"+ RESET + " Já que estamos falando de pioneiros no campo da IA, você sabia que a Universidade Federal da Paraíba foi a primeira instituição pública do país a oferecer uma graduação em Ciência de Dados e Inteligência Artificial? O curso é ofertado desde 2020 e tem o Enem como forma de ingressar.\n");
            resp = 1;
        } else {
            resp = -1; // Caso de "Loja" ou "Inventário"
        }

        return resp;
    }

    public static String enunciadoPergunta4() {
        String alternativa;
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("\n\nQual foi o primeiro programa a usar Inteligência Artificial?\n");
            System.out.println("A. General Problem Solver");
            System.out.println("B. Logic Theorist");
            System.out.println("C. Eliza\n");
            System.out.println("L. Loja");
            System.out.println("I. Inventário\n");
            System.out.print("Escolha: ");
            alternativa = scanner.nextLine();

            if (!alternativa.equalsIgnoreCase("a")
                    && !alternativa.equalsIgnoreCase("b")
                    && !alternativa.equalsIgnoreCase("c")
                    && !alternativa.equalsIgnoreCase("i")
                    && !alternativa.equalsIgnoreCase("l")) {
                System.err.println("Opção Inválida! Selecione novamente.\n");
            }
        } while (!alternativa.equalsIgnoreCase("a")
                && !alternativa.equalsIgnoreCase("b")
                && !alternativa.equalsIgnoreCase("c")
                && !alternativa.equalsIgnoreCase("l")
                && !alternativa.equalsIgnoreCase("i"));

        return alternativa;
    }

    public static int resposta4(String alternativa) {
        int resp = 0;

        if (alternativa.equalsIgnoreCase("a")) {
            System.out.println("\n* RESPOSTA *\n");
            System.out.println(mensagemErrada);
            System.out.println(RED + "O processamento de linguagem natural é uma das áreas de estudo da IA, essa área trata da habilidade de interpretar e processar a linguagem humana natural por sistemas computacionais. Um ótimo exemplo de sua aplicação é o Google tradutor, sendo capaz de captar a fala do usuário e traduzir para a linguagem de sua escolha\n" + RESET);
            System.out.println(BOLD_GREEN + "A alternativa correta é a alternativa B.\n"+ RESET + GREEN + "Logic Theorist, lançada em 1956 e apresentada ao mundo por Allen Newell e Cliff Shaw, tinha o objetivo provar teoremas matemáticos com base em um conjunto de regras e blocos de lógica. Assim, pela primeira vez uma máquina estava sendo usada para resolver tarefas intelectuais\n"+ RESET);
            resp = 0;
        } else if (alternativa.equalsIgnoreCase("b")) {
            System.out.println("\n* RESPOSTA *\n");
            System.out.println(mensagemCorreta);
            System.out.println(GREEN + "Logic Theorist, lançada em 1956 e apresentada ao mundo por Allen Newell e Cliff Shaw, tinha o objetivo provar teoremas matemáticos com base em um conjunto de regras e blocos de lógica. Assim, pela primeira vez uma máquina estava sendo usada para resolver tarefas intelectuais\n" + RESET);
            System.out.println("E como prêmio você acaba de desbloquear uma curiosidade.");
            System.out.println(YELLOW + "Curiosidade: "+ RESET + "Você sabia que a inteligência artificial já ganhou de um campeão mundial de xadrez? No dia 10 de fevereiro de 1996, há exatos 25 anos, o enxadrista Garry Kasparov, tido por alguns como o maior de todos os tempos, perdia uma partida de xadrez para o supercomputador da IBM Deep Blue.\n");
            resp = 1;
        } else if (alternativa.equalsIgnoreCase("c")) {
            System.out.println("\n* RESPOSTA *\n");
            System.out.println(mensagemErrada);
            System.out.println(RED + "Criada em 1966 pelo matemático Joseph Weizenbaum, Eliza é o primeiro software de processamento de linguagem natural. Seu objetivo era funcionar como uma espécie de psicóloga virtual. Na prática, Weizenbaum criou um software capaz de identificar 250 tipos de frases e enganar o interlocutor usando trechos das perguntas em suas respostas\n" + RESET);
            System.out.println(BOLD_GREEN + "A alternativa correta é a alternativa B.\n" + RESET +  GREEN +"Logic Theorist, lançada em 1956 e apresentada ao mundo por Allen Newell e Cliff Shaw, tinha o objetivo provar teoremas matemáticos com base em um conjunto de regras e blocos de lógica. Assim, pela primeira vez uma máquina estava sendo usada para resolver tarefas intelectuais.\n" + RESET);
            resp = 0;
        }

        return resp;
    }

    public static String enunciadoPergunta5() {
        String alternativa;
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("\nQual das seguintes áreas não é um campo de estudo da IA?\n");
            System.out.println("A. Processamento de Linguagem Natural");
            System.out.println("B. Análise de dados");
            System.out.println("C. Redes Neurais\n");
            System.out.println("L. Loja");
            System.out.println("I. Inventário\n");
            System.out.print("Escolha: ");
            alternativa = scanner.nextLine();

            if (!alternativa.equalsIgnoreCase("a")
                    && !alternativa.equalsIgnoreCase("b")
                    && !alternativa.equalsIgnoreCase("c")
                    && !alternativa.equalsIgnoreCase("i")
                    && !alternativa.equalsIgnoreCase("l")) {
                System.err.println("Opção Inválida! Selecione novamente.\n");
            }
        } while (!alternativa.equalsIgnoreCase("a")
                && !alternativa.equalsIgnoreCase("b")
                && !alternativa.equalsIgnoreCase("c")
                && !alternativa.equalsIgnoreCase("l")
                && !alternativa.equalsIgnoreCase("i"));

        return alternativa;
    }

    public static int resposta5(String alternativa) {
        int resp = 0;

        if (alternativa.equalsIgnoreCase("a")) {
            System.out.println("\n* RESPOSTA *\n");
            System.out.println(mensagemErrada);
            System.out.println(RED + "O processamento de linguagem natural é uma das áreas de estudo da IA, essa área trata da habilidade de interpretar e processar a linguagem humana natural por sistemas computacionais. Um ótimo exemplo de sua aplicação é o Google tradutor, sendo capaz de captar a fala do usuário e traduzir para a linguagem de sua escolha\n"+ RESET);
            System.out.println(BOLD_GREEN + "A alternativa correta é a alternativa B.\n" + RESET +  GREEN +"Apesar da IA ser utilizada na análise de dados, a Administração de bancos de dados não é uma área de estudo da inteligência artificial, pois concentra-se principalmente no gerenciamento e na manutenção eficiente dos sistemas de banco de dados\n"+ RESET);
            resp = 0;
        } else if (alternativa.equalsIgnoreCase("b")) {
            System.out.println("\n* RESPOSTA *\n");
            System.out.println(mensagemCorreta);
            System.out.println(GREEN + "Apesar da IA ser utilizada na análise de dados, a Administração de bancos de dados não é uma área de estudo da inteligência artificial, pois concentra-se principalmente no gerenciamento e na manutenção eficiente dos sistemas de banco de dados\n" + RESET);
            System.out.println("E como prêmio você acaba de desbloquear uma curiosidade.");
            System.out.println(YELLOW + "Curiosidade: "+ RESET + "Você sabia que o banco do Itaú utiliza Inteligência Artificial para auxílio na  análise de dados dos documentos jurídicos?A IA é treinada para identificar informações relevantes, como cláusulas, datas e partes envolvidas\n");
            resp = 1;
        } else if (alternativa.equalsIgnoreCase("c")) {
            System.out.println("\n* RESPOSTA *\n");
            System.out.println(mensagemErrada);
            System.out.println(RED + "Redes Neurais é uma das áreas de estudo da IA, essa área conta com algoritmos especializados em reconhecimento de padrões, classificando dados de acordo com suas similaridades, seja por meio de imagens, vídeos, textos ou sons. Em sua essência, é um método  que ensina a máquina a processar dados de uma forma inspirada pelo cérebro humano. Alguns exemplos de suas aplicações: Diagnóstico médico feito pela classificação de imagens; Previsões financeiras feitas pelo processamento de dados históricos de instrumentos financeiros\n" + RESET);
            System.out.println(BOLD_GREEN + "A alternativa correta é a alternativa B.\n" + RESET +  GREEN +"Apesar da IA ser utilizada na análise de dados, a Administração de bancos de dados não é uma área de estudo da inteligência artificial, pois concentra-se principalmente no gerenciamento e na manutenção eficiente dos sistemas de banco de dados\n" + RESET);
            resp = 0;
        }
        return resp;
    }

    public static String enunciadoPergunta6() {
        Scanner scanner = new Scanner(System.in);
        String alternativa;

        do {
            System.out.println("\nQuais das plataformas abaixo usam inteligência artificial para contribuir na educação do usuário?");
            System.out.println("A. Knewton");
            System.out.println("B. Udemy");
            System.out.println("C. Pluralsight\n");
            System.out.println("L. Loja");
            System.out.println("I. Inventário\n");
            System.out.print("Escolha: ");
            alternativa = scanner.nextLine();

            if (!alternativa.equalsIgnoreCase("a")
                    && !alternativa.equalsIgnoreCase("b")
                    && !alternativa.equalsIgnoreCase("c")
                    && !alternativa.equalsIgnoreCase("i")
                    && !alternativa.equalsIgnoreCase("l")) {
                System.err.println("Opção Inválida! Selecione novamente.\n");
            }
        } while (!alternativa.equalsIgnoreCase("a")
                && !alternativa.equalsIgnoreCase("b")
                && !alternativa.equalsIgnoreCase("c")
                && !alternativa.equalsIgnoreCase("l")
                && !alternativa.equalsIgnoreCase("i"));

        return alternativa;
    }

    public static int resposta6(String alternativa) {
        int resp = 0;

        if (alternativa.equalsIgnoreCase("a")) {
            System.out.println("\n* RESPOSTA *\n");
            System.out.println(mensagemCorreta);
            System.out.println(GREEN + "A Knewton é uma plataforma de ensino adaptativo que usa IA para adaptar o conteúdo educacional às necessidades e ritmo de cada aluno, concedendo uma experiência de aprendizagem mais proveitosa\n");
            System.out.println("E como prêmio você acaba de desbloquear uma curiosidade.");
            System.out.println(YELLOW + "Curiosidade: "+ RESET + "Você sabia que a plataforma de idiomas Duolingo utiliza inteligência artificial para contribuir na geração de frases ? ''Large Language Mode'' é o nome da tecnologia que permite prever o jeito mais provável de completar uma frase (a mesma tecnologia da caixa de sugestão de palavras quando estamos escrevendo no celular). Utilizando dessa tecnologia, a plataforma consegue gerar uma quantidade massiva de conteúdo, sem perder a qualidade\n");
            resp = 1;
        } else if (alternativa.equalsIgnoreCase("b")) {
            System.out.println("\n* RESPOSTA *\n");
            System.out.println(mensagemErrada);
            System.out.println(RED + "A Udemy é uma plataforma de aprendizado online que oferece uma vasta variedade de cursos em diferentes áreas do conhecimento. Por mais que a plataforma apresente alguns cursos voltados para inteligência artificial, a plataforma em si não apresenta uso da IA voltado para a educação de seus alunos\n" + RESET);
            System.out.println(BOLD_GREEN + "A alternativa correta é a alternativa A." + RESET +  GREEN + "\nA Knewton é uma plataforma de ensino adaptativo que usa IA para adaptar o conteúdo educacional às necessidades e ritmo de cada aluno, concedendo uma experiência de aprendizagem mais proveitosa\n" + RESET);
            resp = 0;
        } else if (alternativa.equalsIgnoreCase("c")) {
            System.out.println("\n* RESPOSTA *\n");
            System.out.println(mensagemErrada);
            System.out.println(RED + "A Pluralsight é uma plataforma de aprendizado online que oferece uma variedade de cursos relacionados à tecnologia da informação.Por mais que a plataforma apresenta bastante cursos voltados para inteligência artificial, a plataforma em si não apresenta uso da IA voltado para a educação de seus alunos\n" + RESET);
            System.out.println(BOLD_GREEN + "A alternativa correta é a alternativa A." + RESET +  GREEN +"\nA Knewton é uma plataforma de ensino adaptativo que usa IA para adaptar o conteúdo educacional às necessidades e ritmo de cada aluno, concedendo uma experiência de aprendizagem mais proveitosa\n" + RESET);
            resp = 0;
        }

        return resp;
    }

    public static String enunciadoPergunta7() {
        Scanner scanner = new Scanner(System.in);
        String alternativa;

        do {
            System.out.println("\nQual é o nome do Software descrito acima?\n");
            System.out.println("A. Google Classroom");
            System.out.println("B. Student");
            System.out.println("C. Khan academy\n");
            System.out.println("L. Loja");
            System.out.println("I. Inventário\n");
            System.out.print("Escolha: ");
            alternativa = scanner.nextLine();

            if (!alternativa.equalsIgnoreCase("a")
                    && !alternativa.equalsIgnoreCase("b")
                    && !alternativa.equalsIgnoreCase("c")
                    && !alternativa.equalsIgnoreCase("i")
                    && !alternativa.equalsIgnoreCase("l")) {
                System.err.println("Opção Inválida! Selecione novamente.\n");
            }
        } while (!alternativa.equalsIgnoreCase("a")
                && !alternativa.equalsIgnoreCase("b")
                && !alternativa.equalsIgnoreCase("c")
                && !alternativa.equalsIgnoreCase("l")
                && !alternativa.equalsIgnoreCase("i"));

        return alternativa;
    }

    public static int resposta7(String alternativa) {
        int resp = 0;

        if (alternativa.equalsIgnoreCase("a")) {
            System.out.println("\n* RESPOSTA *\n");
            System.out.println(mensagemErrada);
            System.out.println(RED + "Lançado em 2014, a plataforma educacional permite que professores e estudantes compartilhem tarefas, materiais didáticos, façam trabalhos, etc, algo similar a uma sala de aula, como o próprio nome diz. A plataforma utiliza-se sim de inteligência artificial para a criação de aulas, avaliações, dicas e análise de desempenho, porém não é o software descrito acima\n" + RESET);
            System.out.println(BOLD_GREEN + "A alternativa correta é a alternativa B.\n" + RESET +  GREEN +"Criado em 1964 na Universidade de Massachusetts, um dos primeiros softwares a utilizar IA,  no qual resolvia problemas matemáticos descritos em palavras e fornecia um retorno avaliativo com base no desempenho do aluno, abrindo espaço para a ideia de que a tecnologia poderia ser usada para personalizar e melhorar a experiência de aprendizado\n" + RESET);
            resp = 0;
        } else if (alternativa.equalsIgnoreCase("b")) {
            System.out.println("\n* RESPOSTA *\n");
            System.out.println(mensagemCorreta);
            System.out.println(GREEN + "Criado em 1964 na Universidade de Massachusetts, um dos primeiros softwares a utilizar IA,  no qual resolvia problemas matemáticos descritos em palavras e fornecia um retorno avaliativo com base no desempenho do aluno, abrindo espaço para a ideia de que a tecnologia poderia ser usada para personalizar e melhorar a experiência de aprendizado\n" + RESET);
            System.out.println("E como prêmio você acaba de desbloquear uma curiosidade.");
            System.out.println(YELLOW + "Curiosidade: "+ RESET + "Você sabia que pouco mais da metade (52%) dos universitários brasileiros usam inteligência artificial (IA) nos estudos, de acordo com uma pesquisa global realizada pela Chegg.org.\n");
            resp = 1;
        } else if (alternativa.equalsIgnoreCase("c")) {
            System.out.println("\n* RESPOSTA *\n");
            System.out.println(mensagemErrada);
            System.out.println(RED + "Criada em 2008 por Salman Khan, a Khan Academy é uma organização educacional sem fins lucrativos que oferece exercícios, vídeos e um quadro de aprendizado personalizado para cada aluno estudar em seu próprio ritmo. Apesar de aderir em 2023 o uso da tecnologia, ela não foi uma pioneira no meio digital\n" + RESET);
            System.out.println(BOLD_GREEN + "A alternativa correta é a alternativa B." + RESET +  GREEN  + "\nCriado em 1964 na Universidade de Massachusetts, um dos primeiros softwares a utilizar IA,  no qual resolvia problemas matemáticos descritos em palavras e fornecia um retorno avaliativo com base no desempenho do aluno, abrindo espaço para a ideia de que a tecnologia poderia ser usada para personalizar e melhorar a experiência de aprendizado\n" + RESET);
            resp = 0;
        }

        return resp;
    }

    public static String enunciadoPergunta8() {
        Scanner scanner = new Scanner(System.in);
        String alternativa;

        do {
            System.out.println("\nQual das formas abaixo não é uma utilização da inteligência artificial na área da saúde?\n");
            System.out.println("A. Auxiliando no tratamento de câncer, com dados clínicos e genéticos do paciente, indicando possíveis tratamentos disponíveis");
            System.out.println("B. A inteligência artificial na saúde permite diagnósticos precoces e identificação de condições clínicas como tumores, prevenindo complicações e indicando tratamentos adequados");
            System.out.println("C. O usuário utiliza um aplicativo onde descreve seus sintomas e a inteligência artificial dá um diagnóstico substituível de um médico junto ao tratamento necessário.\n");
            System.out.println("L. Loja");
            System.out.println("I. Inventário\n");
            System.out.print("Escolha: ");
            alternativa = scanner.nextLine();

            if (!alternativa.equalsIgnoreCase("a")
                    && !alternativa.equalsIgnoreCase("b")
                    && !alternativa.equalsIgnoreCase("c")
                    && !alternativa.equalsIgnoreCase("i")
                    && !alternativa.equalsIgnoreCase("l")) {
                System.err.println("Opção Inválida! Selecione novamente.\n");
            }
        } while (!alternativa.equalsIgnoreCase("a")
                && !alternativa.equalsIgnoreCase("b")
                && !alternativa.equalsIgnoreCase("c")
                && !alternativa.equalsIgnoreCase("l")
                && !alternativa.equalsIgnoreCase("i"));

        return alternativa;
    }

    public static int resposta8(String alternativa) {
        int resp = 0;

        if (alternativa.equalsIgnoreCase("a")) {
            System.out.println("\n* RESPOSTA *\n");
            System.out.println(mensagemErrada);
            System.out.println(RED + "A inteligência artificial pode ser utilizada para auxiliar no tratamento de câncer, com dados clínicos e genéticos do paciente, indicando possíveis tratamentos disponíveis. Um bom exemplo é o algoritmo desenvolvido pela pesquisadora Daniella Castro Araújo, que utiliza de exames de sangue rotineiros, reconhecendo padrões em grupos de pacientes com e sem câncer, assim podendo dar um diagnóstico precoce para prevenir o câncer de mama, o atual foco da ferramenta\n" + RESET);
            System.out.println(BOLD_GREEN + "A alternativa correta é a alternativa C.\n" + RESET +  GREEN +"Existem sim aplicativos que utilizam de Inteligência artificial para dar uma sugestão de diagnóstico, como é o caso da ADA.A ADA foi desenvolvida originalmente para dar apoio na tomada de decisões clínicas, porém com o auxílio de equipes médicas a plataforma também conta com um diagnóstico clínico automatizado, onde o usuário descreve os sintomas e em questões de instantes é dado um retorno. Entretanto, não substitui uma consulta médica com um especialista, e não fornece a mesma precisão no tratamento\n" + RESET);
            resp = 0;
        } else if (alternativa.equalsIgnoreCase("b")) {
            System.out.println("\n* RESPOSTA *\n");
            System.out.println(mensagemErrada);
            System.out.println(RED + "A inteligência artificial pode ser utilizada para diagnósticos precoces e identificação de condições clínicas como tumores, prevenindo complicações e indicando tratamentos adequados. A tecnologia que permite esse tipo de aplicação são as redes neurais, que junto a um banco de dados analisam pequenas alterações ou imagens e geram diagnósticos precoces\n" + RESET);
            System.out.println(BOLD_GREEN + "A alternativa correta é a alternativa C.\n" + RESET +  GREEN +"\nExistem sim aplicativos que utilizam de Inteligência artificial para dar uma sugestão de diagnóstico, como é o caso da ADA.A ADA foi desenvolvida originalmente para dar apoio na tomada de decisões clínicas, porém com o auxílio de equipes médicas a plataforma também conta com um diagnóstico clínico automatizado, onde o usuário descreve os sintomas e em questões de instantes é dado um retorno. Entretanto, não substitui uma consulta médica com um especialista, e não fornece a mesma precisão no tratamento\n" + RESET);
            resp = 0;
        } else if (alternativa.equalsIgnoreCase("c")) {
            System.out.println("\n* RESPOSTA *\n");
            System.out.println(mensagemCorreta);
            System.out.println(GREEN + "Existem sim aplicativos que utilizam de Inteligência artificial para dar uma sugestão de diagnóstico, como é o caso da ADA.A ADA foi desenvolvida originalmente para dar apoio na tomada de decisões clínicas, porém com o auxílio de equipes médicas a plataforma também conta com um diagnóstico clínico automatizado, onde o usuário descreve os sintomas e em questões de instantes é dado um retorno. Entretanto, não substitui uma consulta médica com um especialista, e não fornece a mesma precisão no tratamento\n" + RESET);
            System.out.println("E como prêmio você acaba de desbloquear uma curiosidade.");
            System.out.println(YELLOW + "Curiosidade: "+ RESET + "Você sabia que o hospital 9 de julho foi o primeiro hospital do mundo a utilizar inteligência artificial para ampliar a segurança de seus pacientes? O sistema foi desenvolvido pela Microsoft e é responsável pelo monitoramento dos pacientes por meio de sensores inteligentes que detectam movimentações fora do padrão em tempo real, assim prevenindo quedas hospitalares\n");
            resp = 1;
        }

        return resp;
    }

    // ========================================================================================
    public static String NomeLoja(int alternativa) {
        String nome = "";
        switch (alternativa) {
            case 1:
                nome = "Vida";
                break;
            case 2:
                nome = "Dicas";
                break;
            case 3:
                nome = "Eliminar Alternativa";
                break;
            case 4:
                nome = "NextQuestion";
                break;
            default:
                System.out.println("eroooooo teste 2");
        }
        return nome;
    }

    public static int custo(int alternativa, int[] vetor) {
        int preco = 0;
        switch (alternativa) {
            case 1:
                preco = vetor[6];
                break;
            case 2:
                preco = vetor[3];
                break;
            case 3:
                preco = vetor[4];
                break;
            case 4:
                preco = vetor[5];
                break;
        }
        return preco;
    }

    public static int LojaAnuncio(Scanner scanner) {
        int alternativa = 0;
        boolean validInput = false;

        do {
            System.out.println("\n* LOJA *\n [1] Vida  |  [2] Dicas  |  [3] Eliminar Alternativa  |  [4] NextQuestion  |  [5] Sair\n");
            System.out.println("Escolha o item que deseja comprar:");

            if (scanner.hasNextInt()) {
                alternativa = scanner.nextInt();
                if (alternativa >= 1 && alternativa <= 5) {
                    validInput = true;
                    return alternativa;
                } else {
                    System.err.println("\nOpção inválida. Tente novamente.");
                }
            } else {
                System.err.println("\nEntrada inválida. Por favor, insira um número.");
                scanner.next(); // limpa a entrada inválida
            }
        } while (!validInput);

        return alternativa;
    }


    public static char Chek(String nome, int preco, Scanner scanner) {
        char voltar;
        do {
            System.out.println("\nVocê escolheu: " + nome);
            System.out.println(nome + " custa " + preco);
            System.out.println("Deseja comprar?\n[1] Sim  |  [2] Não");
            System.out.println("Escolha:");
            voltar = scanner.next().charAt(0);
        } while (voltar != '1' && voltar != '2');
        return voltar;
    }

    public static int SorN(char voltar) {
        int voltando = 0;
        switch (voltar) {
            case '1':
                voltando = 1;
                break;
            case '2':
                voltando = 0;
                break;
        }
        return voltando;
    }

    public static int[] checandoCompra(int preco, int[] GuardandoGame, int alternativa) {
        if (GuardandoGame[1] >= preco) {
            GuardandoGame[1] -= preco;
            switch (alternativa) {
                case 1:
                    GuardandoGame[2]++;
                    break;
                case 2:
                    GuardandoGame[3]++;
                    break;
                case 3:
                    GuardandoGame[4]++;
                    break;
                case 4:
                    GuardandoGame[5]++;
                    break;
                default:
                    System.err.println("Opcao Invalida!");
            }
        } else {
            System.err.println("\nDinheiro insuficiente\n");
        }
        return GuardandoGame;
    }

    public static int[] loja(int[] GuardandoGame, int[] vetor, String nome) {
        int alternativa;
        int preco;
        char voltar;
        int voltando;
        Scanner scanner = new Scanner(System.in);
        do {
            alternativa = LojaAnuncio(scanner);
            voltando = 1;
            if (alternativa != 5) {
                nome = NomeLoja(alternativa);
                preco = custo(alternativa, vetor);
                voltar = Chek(nome, preco, scanner);
                if (voltar == '1') {
                    GuardandoGame = checandoCompra(preco, GuardandoGame, alternativa);
                    voltando = 0;
                } else if (voltar == '2') {
                    voltando = 0;
                }
            } else if (alternativa == 5) {
                voltando = 1;
            }
        } while (voltando == 0);

        return GuardandoGame;
    }

    public static void Dicas(int pergunta) {
        switch (pergunta) {
            case 1:
                System.out.println(PURPLE + "Dica: A inteligência artificial busca compreender o raciocínio humano\n" + RESET);
                break;

            case 2:
                System.out.println(PURPLE + "Dica: Ele é conhecido como o pai da computação\n" + RESET);
                break;

            case 3:
                System.out.println(PURPLE + "Dica: A conferência possui o nome de uma universidade\n" + RESET);
                break;

            case 4:
                System.out.println(PURPLE + "Dica: O programa era conhecido por resolver teoremas matemáticos\n" + RESET);
                break;

            case 5:
                System.out.println(PURPLE + "Dica: *ANÁLISE* as alternativas\n"+ RESET);
                break;

            case 6:
                System.out.println(PURPLE + "Dica: Ela chegou no Brasil há 10 anos\n" + RESET);
                break;

            case 7:
                System.out.println(PURPLE + "Dica: Todos nós somos estudantes, lembre-se disso\n" + RESET);
                break;

            case 8:
                System.out.println(PURPLE + "Dica: A conferência possui o nome de uma universidade\n" + RESET);
                break;
        }
    }

    public static void Eliminar(int pergunta) {
        switch (pergunta) {
            case 1:
                System.out.println(RED + "Alternativa Eliminada:\nC. A área que busca decifrar o código genético humano e replicá-lo nas máquinas por meio de algoritmos e sistemas" + RESET);
                break;

            case 2:
                System.out.println(RED +"Alternativa Eliminada:\nB. Em 1956, com a conferência de Dartmouth, onde o termo *inteligência artificial* foi oficialmente criado."+ RESET);
                break;

            case 3:
                System.out.println(RED +"Alternativa Eliminada:\nA. WWDC (Apple Worldwide Developers Conference)"+ RESET);
                break;

            case 4:
                System.out.println(RED +"Alternativa Eliminada:\nA. General Problem Solver" + RESET);
                break;

            case 5:
                System.out.println(RED +"Alternativa Eliminada:\nC. Redes Neurais"+ RESET);
                break;

            case 6:
                System.out.println(RED +"Alternativa Eliminada:\nB. Udemy" + RESET);
                break;

            case 7:
                System.out.println(RED +"Alternativa Eliminada:\nA. Google Classroom" + RESET);
                break;

            case 8:
                System.out.println(RED +"Alternativa Eliminada:\nB. A inteligência artificial na saúde permite diagnósticos precoces e identificação de condições clínicas como tumores, prevenindo complicações e indicando tratamentos adequado"+ RESET);
                break;
        }
    }

    public static int[] inventario(int[] GuardandoGame, int pergunta, int controle) {
        Scanner scanner = new Scanner(System.in);
        int escolhas;
        char volta = '\0';

        do {
            System.out.println("\nVocê selecionou o inventário\n");
            System.out.println("Você possui:\n");
            System.out.println("Dicas: " + GuardandoGame[3]);
            System.out.println("Eliminar Alternativa: " + GuardandoGame[4]);
            System.out.println("NextQuestion: " + GuardandoGame[5]);
            System.out.println("[1] Dica  |  [2] Eliminar Alternativa  |  [3] NextQuestion  |  [4] Sair\n");
            System.out.print("Escolha: ");

            // Verifica se a entrada é um número inteiro
            if (scanner.hasNextInt()) {
                escolhas = scanner.nextInt();

                switch (escolhas) {
                    case 1:
                        if (GuardandoGame[3] >= 1) {
                            // Chama o método Dicas
                            Dicas(pergunta);
                            GuardandoGame[3]--;
                            volta = 1;
                        } else {
                            System.err.println("\nVocê não possui Dicas o suficiente\n");
                            volta = 0;
                        }
                        GuardandoGame[6] = 0;
                        break;

                    case 2:
                        if (GuardandoGame[4] >= 1) {
                            // Chama o método Eliminar
                            Eliminar(pergunta);
                            GuardandoGame[4]--;
                            volta = 1;
                        } else {
                            System.err.println("\nVocê não possui Eliminar Questões o suficiente\n");
                            volta = 0;
                        }
                        GuardandoGame[6] = 0;
                        break;

                    case 3:
                        if (GuardandoGame[5] >= 1) {
                            GuardandoGame[5]--;
                            GuardandoGame[6] = 1;
                            volta = 1;
                        } else {
                            System.err.println("\nVocê não possui NextQuestion o suficiente\n");
                            volta = 0;
                        }
                        break;

                    case 4:
                        volta = 1;
                        GuardandoGame[6] = 0;
                        break;
                    default:
                        System.err.println("Opção Inválida! Selecione Novamente!");
                }
            } else {
                // Limpa a entrada inválida
                System.err.println("Entrada inválida. Por favor, insira um número.");
                scanner.next();
            }
        } while (volta != 1);

        return GuardandoGame;
    }

    public static int[] CertoOuErrado(int resp, int[] vetor, int[] GuardandoGame) {
        switch (resp) {
            case 1:
                GuardandoGame[0] += vetor[0];
                GuardandoGame[1] += vetor[1];
                break;

            case 0:
                GuardandoGame[2]--;
                break;
        }

        return GuardandoGame;
    }

    public static int[] pergunta1(int[] GuardandoGame, int[] vetor) {
        int pergunta = 1; // variavel auxiliar na dica
        int controle;
        int resp = 0;
        String alternativa;
        String nome = "";
        mostra(GuardandoGame);
        System.out.println("\nSeja muito bem-vindo! Estamos muito felizes em ter você por aqui! Para embarcarmos em uma jornada de aprendizado e curiosidades, vamos primeiro ver qual o seu entendimento quando falamos sobre IA.");

        do {
            controle = 0;
            alternativa = EnunciadoPergunta1();
            if (alternativa.equalsIgnoreCase("a") || alternativa.equalsIgnoreCase("b") || alternativa.equalsIgnoreCase("c")) {
                resp = resposta1(alternativa);
                controle = 1;
            } else if (alternativa.equalsIgnoreCase("l")) {
                GuardandoGame = loja(GuardandoGame, vetor, nome);
                controle = 0;
            } else if (alternativa.equalsIgnoreCase("i")) {
                GuardandoGame = inventario(GuardandoGame, pergunta, controle);
                controle = GuardandoGame[6];
            }
        } while (controle != 1);
        GuardandoGame = CertoOuErrado(resp, vetor, GuardandoGame);
        return GuardandoGame;
    }

    public static int[] pergunta2(int[] GuardandoGame, int[] vetor) {
        int pergunta = 2; // variavel auxiliar na dica
        int controle;
        int resp = 0;
        String alternativa;
        String nome = "";
        mostra(GuardandoGame);
        System.out.println("Agora que já sabemos o que é inteligência artificial e o que essa área busca, vamos ver quando surgiu um dos primeiros vestígios desse conceito");

        do {
            controle = 0;
            alternativa = EnunciadoPergunta2();
            if (alternativa.equalsIgnoreCase("a") || alternativa.equalsIgnoreCase("b") || alternativa.equalsIgnoreCase("c")) {
                resp = resposta2(alternativa);
                controle = 1;
            } else if (alternativa.equalsIgnoreCase("l")) {
                GuardandoGame = loja(GuardandoGame, vetor, nome);
                controle = 0;
            } else if (alternativa.equalsIgnoreCase("i")) {
                GuardandoGame = inventario(GuardandoGame, pergunta, controle);
                controle = GuardandoGame[6];
            }
        } while (controle != 1);
        GuardandoGame = CertoOuErrado(resp, vetor, GuardandoGame);
        return GuardandoGame;
    }

    public static int[] pergunta3(int[] GuardandoGame, int[] vetor) {
        int pergunta = 3; // variavel auxiliar na dica
        int controle;
        int resp = 0;
        String alternativa;
        String nome = "";
        mostra(GuardandoGame);
        System.out.println("Tendo em mente como surgiu a ideia da inteligência artificial, devemos falar do primeiro evento relacionado a IA, que com certeza foi um marco para o seu desenvolvimento, a famosa conferência: ");

        do {
            controle = 0;
            alternativa = EnunciadoPergunta3();
            if (alternativa.equalsIgnoreCase("a") || alternativa.equalsIgnoreCase("b") || alternativa.equalsIgnoreCase("c")) {
                resp = resposta3(alternativa);
                controle = 1;
            } else if (alternativa.equalsIgnoreCase("l")) {
                GuardandoGame = loja(GuardandoGame, vetor, nome);
                controle = 0;
            } else if (alternativa.equalsIgnoreCase("i")) {
                GuardandoGame = inventario(GuardandoGame, pergunta, controle);
                controle = GuardandoGame[6];
            }
        } while (controle != 1);
        GuardandoGame = CertoOuErrado(resp, vetor, GuardandoGame);
        return GuardandoGame;
    }

    public static int[] pergunta4(int[] GuardandoGame, int[] vetor) {
        int pergunta = 4; // variavel auxiliar na dica
        int controle;
        int resp = 0;
        String alternativa;
        String nome = "";
        mostra(GuardandoGame);
        System.out.println("A conferência de Dartmouth certamente foi de extrema importância para o desenvolvimento da IA, tanto que, pela primeira vez foi apresentado um software que utilizou-se da tecnologia");

        do {
            controle = 0;
            alternativa = enunciadoPergunta4();
            if (alternativa.equalsIgnoreCase("a") || alternativa.equalsIgnoreCase("b") || alternativa.equalsIgnoreCase("c")) {
                resp = resposta4(alternativa);
                controle = 1;
            } else if (alternativa.equalsIgnoreCase("l")) {
                GuardandoGame = loja(GuardandoGame, vetor, nome);
                controle = 0;
            } else if (alternativa.equalsIgnoreCase("i")) {
                GuardandoGame = inventario(GuardandoGame, pergunta, controle);
                controle = GuardandoGame[6];
            }
        } while (controle != 1);
        GuardandoGame = CertoOuErrado(resp, vetor, GuardandoGame);
        return GuardandoGame;
    }

    public static int[] pergunta5(int[] GuardandoGame, int[] vetor) {
        int pergunta = 5; // variavel auxiliar na dica
        int controle;
        int resp = 0;
        String alternativa;
        String nome = "";
        mostra(GuardandoGame);
        System.out.println("Ao passar dos anos foram realizadas pesquisas, e a especialização na IA foi se aprofundando cada vez mais, hoje já contamos com campos específicos para cada área de estudo");

        do {
            controle = 0;
            alternativa = enunciadoPergunta5();
            if (alternativa.equalsIgnoreCase("a") || alternativa.equalsIgnoreCase("b") || alternativa.equalsIgnoreCase("c")) {
                resp = resposta5(alternativa);
                controle = 1;
            } else if (alternativa.equalsIgnoreCase("l")) {
                GuardandoGame = loja(GuardandoGame, vetor, nome);
                controle = 0;
            } else if (alternativa.equalsIgnoreCase("i")) {
                GuardandoGame = inventario(GuardandoGame, pergunta, controle);
                controle = GuardandoGame[6];
            }
        } while (controle != 1);
        GuardandoGame = CertoOuErrado(resp, vetor, GuardandoGame);
        return GuardandoGame;
    }

    public static int[] pergunta6(int[] GuardandoGame, int[] vetor) {
        int pergunta = 6; // variavel auxiliar na dica
        int controle;
        int resp = 0;
        String alternativa;
        String nome = "";
        mostra(GuardandoGame);
        System.out.println("Como apresentado, vimos que a inteligência artificial está mais inserida no nosso cotidiano do que pensamos. Seguindo essa linha de raciocínio, é capaz da inteligência artificial estar presente na educação? A resposta é sim, é possível!");

        do {
            controle = 0;
            alternativa = enunciadoPergunta6();
            if (alternativa.equalsIgnoreCase("a") || alternativa.equalsIgnoreCase("b") || alternativa.equalsIgnoreCase("c")) {
                resp = resposta6(alternativa);
                controle = 1;
            } else if (alternativa.equalsIgnoreCase("l")) {
                GuardandoGame = loja(GuardandoGame, vetor, nome);
                controle = 0;
            } else if (alternativa.equalsIgnoreCase("i")) {
                GuardandoGame = inventario(GuardandoGame, pergunta, controle);
                controle = GuardandoGame[6];
            }
        } while (controle != 1);
        GuardandoGame = CertoOuErrado(resp, vetor, GuardandoGame);
        return GuardandoGame;
    }

    public static int[] pergunta7(int[] GuardandoGame, int[] vetor) {
        int pergunta = 7; // variavel auxiliar na dica
        int controle;
        int resp = 0;
        String alternativa;
        String nome = "";
        mostra(GuardandoGame);
        System.out.println("Como apresentado, vimos que a inteligência artificial está mais inserida no nosso cotidiano do que pensamos. Seguindo essa linha de raciocínio, é capaz da inteligência artificial estar presente na educação? A resposta é sim, é possível!");

        do {
            controle = 0;
            alternativa = enunciadoPergunta7();
            if (alternativa.equalsIgnoreCase("a") || alternativa.equalsIgnoreCase("b") || alternativa.equalsIgnoreCase("c")) {
                resp = resposta7(alternativa);
                controle = 1;
            } else if (alternativa.equalsIgnoreCase("l")) {
                GuardandoGame = loja(GuardandoGame, vetor, nome);
                controle = 0;
            } else if (alternativa.equalsIgnoreCase("i")) {
                GuardandoGame = inventario(GuardandoGame, pergunta, controle);
                controle = GuardandoGame[6];
            }
        } while (controle != 1);
        GuardandoGame = CertoOuErrado(resp, vetor, GuardandoGame);
        return GuardandoGame;
    }

    public static int[] pergunta8(int[] GuardandoGame, int[] vetor) {
        int pergunta = 8; // variavel auxiliar na dica
        int controle;
        int resp = 0;
        String alternativa;
        String nome = "";
        mostra(GuardandoGame);
        System.out.println("Como apresentado, vimos que a inteligência artificial está mais inserida no nosso cotidiano do que pensamos. Seguindo essa linha de raciocínio, é capaz da inteligência artificial estar presente na educação? A resposta é sim, é possível!");

        do {
            controle = 0;
            alternativa = enunciadoPergunta8();
            if (alternativa.equalsIgnoreCase("a") || alternativa.equalsIgnoreCase("b") || alternativa.equalsIgnoreCase("c")) {
                resp = resposta8(alternativa);
                controle = 1;
            } else if (alternativa.equalsIgnoreCase("l")) {
                GuardandoGame = loja(GuardandoGame, vetor, nome);
                controle = 0;
            } else if (alternativa.equalsIgnoreCase("i")) {
                GuardandoGame = inventario(GuardandoGame, pergunta, controle);
                controle = GuardandoGame[6];
            }
        } while (controle != 1);
        GuardandoGame = CertoOuErrado(resp, vetor, GuardandoGame);
        return GuardandoGame;
    }

    public static void fim(int[] GuardandoGame) {

        System.out.println("\n");
        System.out.println(BOLD_BLUE + "================================" + RESET);
        System.out.println("  VOCÊ FINALIZOU O QUIZ  ");
        System.out.println(" Parabéns sua pontuação foi: " + BOLD_GREEN +GuardandoGame[0] + RESET);
        System.out.println(BOLD_BLUE + "================================" + RESET);

        System.out.println("\n");
        reiniciarGame();
    }

    public static void reiniciarGame() {
        Scanner scanner = new Scanner(System.in);
        boolean validInput = false;

        System.out.println("Para iniciar um novo jogo digite [1]");

        do {
            if (scanner.hasNextInt()) {
                int proxtela = scanner.nextInt();
                if (proxtela == 1) {
                    nomeJogador();
                    comeco();
                    regras();
                    validInput = true;
                } else {
                    System.err.println("\nOpção Inválida! Selecione novamente.");
                }
            } else {
                System.err.println("\nOpção Inválida! Selecione novamente.");
                scanner.next();
            }
        } while (!validInput);
    }

    public static void executarPerguntas() {
        String alternativa = EnunciadoPergunta1();
        int resposta = resposta1(alternativa);
        System.out.println("Resposta: " + resposta);

        String alternativa2 = EnunciadoPergunta2();
        int resposta2 = resposta2(alternativa2);
        System.out.println("Resposta: " + resposta2);

        String alternativa3 = EnunciadoPergunta3();
        int resposta3 = resposta3(alternativa3);
        System.out.println("Resposta: " + resposta3);

        String alternativa4 = enunciadoPergunta4();
        int resposta4 = resposta4(alternativa4);
        System.out.println("Resposta: " + resposta4);

        String alternativa5 = enunciadoPergunta5();
        int resposta5 = resposta5(alternativa5);
        System.out.println("Resposta: " + resposta5);

        String alternativa6 = enunciadoPergunta6();
        int resposta6 = resposta6(alternativa6);
        System.out.println("Resposta: " + resposta6);

        String alternativa7 = enunciadoPergunta7();
        int resposta7 = resposta7(alternativa7);
        System.out.println("Resposta: " + resposta7);

        String alternativa8 = enunciadoPergunta8();
        int resposta8 = resposta8(alternativa8);
        System.out.println("Resposta: " + resposta8);
    }

    public static void proximaTela() {
        Scanner scanner = new Scanner(System.in);
        boolean validInput = false;

        System.out.println("Para continuar digite [1]");

        do {
            // Verifica se a entrada é um número inteiro
            if (scanner.hasNextInt()) {
                int proxtela = scanner.nextInt();
                if (proxtela == 1) {
                    validInput = true;
                } else {
                    System.err.println("\nOpção Inválida! Selecione novamente.");
                }
            } else {
                // Caso a entrada não seja um número, exibe mensagem de erro
                System.err.println("\nOpção Inválida! Selecione novamente.");
                scanner.next(); // Consome a entrada inválida
            }
        } while (!validInput);
    }

    public static void inicio(int[] vetor, int[] GuardandoGame) {
        Scanner scanner = new Scanner(System.in);

        nomeJogador();
        comeco();
        regras();
        vetor = EscolhendoModo();
        GuardandoGame = EstoqueGame(vetor);
        GuardandoGame = pergunta1(GuardandoGame, vetor);
        proximaTela();

        if (GuardandoGame[2] >= 1) {
            GuardandoGame = pergunta2(GuardandoGame, vetor);
            proximaTela();
            if (GuardandoGame[2] >= 1) {
                GuardandoGame = pergunta3(GuardandoGame, vetor);
                proximaTela();
                if (GuardandoGame[2] >= 1) {
                    GuardandoGame = pergunta4(GuardandoGame, vetor);
                    proximaTela();
                    if (GuardandoGame[2] >= 1) {
                        GuardandoGame = pergunta5(GuardandoGame, vetor);
                        proximaTela();
                        if (GuardandoGame[2] >= 1) {
                            GuardandoGame = pergunta6(GuardandoGame, vetor);
                            proximaTela();
                            if (GuardandoGame[2] >= 1) {
                                GuardandoGame = pergunta7(GuardandoGame, vetor);
                                proximaTela();
                                if (GuardandoGame[2] >= 1) {
                                    GuardandoGame = pergunta8(GuardandoGame, vetor);
                                    proximaTela();
                                    fim(GuardandoGame);
                                } else {
                                    fim(GuardandoGame);
                                }
                            } else {
                                fim(GuardandoGame);
                            }
                        } else {
                            fim(GuardandoGame);
                        }
                    } else {
                        fim(GuardandoGame);
                    }
                } else {
                    fim(GuardandoGame);
                }
            } else {
                fim(GuardandoGame);
            }
        } else {
            fim(GuardandoGame);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] vetor = new int[7]; // Vetor para guardar os parametros de cada modo de jogo
        int[] GuardandoGame = new int[6]; // Armazena os pontos, moedas, vidas e quantidades de Ups que o usuario tem no inventario

        inicio(vetor, GuardandoGame);
        executarPerguntas();

        int alternativaLoja;
        do {
            alternativaLoja = LojaAnuncio(scanner);
            if (alternativaLoja != 5) {
                String nome = NomeLoja(alternativaLoja);
                int preco = custo(alternativaLoja, vetor);
                char voltar = Chek(nome, preco, scanner);
                if (SorN(voltar) == 1) {
                    System.out.println("Compra realizada com sucesso!");
                } else {
                    System.out.println("Compra cancelada.");
                }
            }
        } while (alternativaLoja != 5);
    }
}