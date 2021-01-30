# Java Alura - Anotações

## Curso 1 (De 26/01/2021 a ??? - Revisão)

### Java JRE e JDK: Escreva o seu primeiro código com Eclipse

JRE (Java Runtime Enviroment) é composto pela JVM (Java Virtual Machine) e por bibliotecas. O JVM é utilizar para ler e executar o bytecode. 

JDK (Java Development Kit) é composto pelo JRE mais o kit para desenvolver aplicações Java. Dentro do JDK está o compilador Java, que é utilizado para gerar o bytecode que a JVM vai executar. 

#### Observações da instalação no Windows

Quando instalamos o JDK em um ambiente Windows, se tentarmos executar o comando ```javac``` (que chama o compilador do Java) no ```cmd```, o terminal não vai encontrar o compilador e nos dará uma mensagem de erro. Para que esse comando funcione, precisamos colocar o diretório ``bin`` (de binário) no nosso ambiente de variáveis. 

#### "Primeiro" programa Java

Como é tradição, o meu "primeiro" programa em Java vou exibir a mensagem ```Olá mundo!```. Diferente do C, Java é um pouco mais verboso, então preciso escrever um pouco mais para exibir a minha mensagem. 

```java
    public class Programa {
        public static void main(String[] args) {
            System.out.println("Olá mundo!");
        }
    }

```
Esse arquivo será salvo como Programa.java. O nome do arquivo precisa ter o mesmo nome da classe principal do programa, nesse caso é ``Programa``, e precisamos usar a extenção ``.java`` para conseguir compilar. 

Para compilar esse programa no terminal, vamos inserir o comando ``javac Programa.java``. 

Depois de compilado, é gerado um novo arquivo chamado ``Programa.class`` e para executá-lo, vamos chamar a JVM com o comando ``java Programa``. Quando vamos executar, nós não temos que passar o nome do arquivo, tipo ```Programa.class```, mas sim chamar a classe principal (não sei se é correto chamar de classe principal), que é ```Programa```. 

#### Observações sobre o Eclipse

A tela toda do Eclipse é chamada de ``perspectiva``, que é composta de várias ``views``. Onde eu edito o meu código, vejo os meus arquivos ou as mensagens de erro são ``views``. 

#### Tipagem

O Java é estaticamente e fortemente tipado, ou seja, toda vez que vamos declarar uma variável, temos que indicar qual vai ser o tipo dela. 

#### Características (pegadinhas)

Existem algumas particularidades quando operações matemágicas são feitas com Java. 

Primeiro caso: se tentarmos dividir ``5`` por ``2`` como ``int``, o Java não fazer um arredondamento, ele vai truncar o valor.

```java
int divisao = 5 / 2;
System.out.println(divisao);
// Resultado: 2
```

Segundo caso: se tentarmos fazer a mesma divisão, só que com o tipo ``double``, o resultado é quase o mesmo.

```java
double divisao = 5 / 2;
System.out.println(divisao);
// Resultado: 2.0
```

O que acontece nesse caso é que o Java primeiro faz a operação da direita e depois volta pra esquerda para ver o tipo, como ele não encontrou nenhum número com ponto flutuante na direita, depois que ele ler o ``double`` na esquerda ele não vai refazer a conta. Para obter o resultado de ``2.5``, temos que fazer conforme abaixo: 

```java
double divisao = 5.0 / 2;
System.out.println(divisao);
// Resultado: 2.5
```

Quando o compilador lê o ``5.0``, ele já entende que é um double, e com isso faz a operação e o resultado é ``2.5``. 

#### Type casting 

Type casting é uma conversão de tipos. Vamos supor que declarei uma variável double salario = 15000.00 e depois uma int valor = salario. Isso aqui não vai compilar porque não são do mesmo tipo. Para fazer isso da certo, temos que usar o type casting, assim: 

```java
double salario = 15000.00;
int valor = (int) salario;
```

Se fizermos o oposto, conforme abaixo, o compilador não encontra erro pois é possível colocar um ``int`` dentro de um ``double``

```java
int salario = 15000;
double valor = salario;
```

#### Tipos primitivos

+ int: valor de 32 bits
+ long: valor de 64 bits
+ short:  valor de 16 bits
+ double: valor de 64 bits
+ float: valor de 32 bits
+ byte: valor de um byte 

Quando vamos declarar um long, precisamos colocar o ``l`` ou ``L`` de literal no final do número, assim: 

```java
long numeroGrande = 123445L;
```

No float é parecido, ou a gente põe um ``f`` ou fazemos o type casting. 

```java
float pontoFlutuante1 = 22.3f;
float pontoFlutuante2 - (float) 234,3;
```

#### Char e String 

Além dos tipos primitivos citados acima, temos o tipo ``char``, que armazena somente um caractere entre aspas simples. Assim como no C, o ``char`` é um ``int`` um pouco diferente, que se eu não me engano aceita somente números inteiros positivos, visto que se colocarmos um número dentro de uma variável ``char`` e depois imprimir, ele vai trazer o caractere correspondente na tabela ``UNICODE``. 

**Exemplo 1:** 

```java
char letra = 'a';
char codigoLetra = 97; 
```

No exemplo acima, eu declarei duas variáveis aparentemente com dois valores diferentes. Porém, quando for imprimir elas, as saídas terão o mesmo resultado ``a``. Isso ocorre porque na variável ``letra`` estamos declarando o literal ``a`` e no ``codigoLetra`` estamos passando o número que correspondente à letra ``a`` na tabela ``UNICODE``. 

**Exemplo 2: **

```java
char letra = 'a';
letra = (char) (letra + 1);
```

Aqui eu estou querendo printar a próxima letra na tabela UNICODE fazendo uma soma. No java eu não posso simplesmente somar assim ``letra = letra + 1``. Se fizermos isso, o código não compila. Isso ocorre porque quando o compilador for fazer a soma de letra + 1, ele vai converter tudo para int, que é um tipo maior (maior de tamanho mesmo, visto que ele comporta um número de 64 bits), e um ``int`` não cabe em um ``char``. Nesse caso precisamos fazer duas alterações: a primeira é fazer o type casting colocar o (char) antes da soma; e a segunda é colocar a soma entre parenteses (eu não estou muito satisfeito com a resposta que o Paulo deu. Vou procurar depois.). 

A gente pode escrever essa soma de uma forma melhor também. Abaixo seguem duas opções: 

```java
char letra = 'a';
letra += (char) 1;
```

```java
char letra = 'a';
letra++;
```

A ```String``` não é um tipo primitivo do Java, tem um arquivo bem lindo que eu não entendi nada fazendo a definição de tipo. Com a string, é possível colocar uma cadeia de caracteres entre aspas duplas, conforme abaixo: 

```java
String palavra = "Lorem Ipsum is simply dummy text of the printing and typesetting industry."
```

Como ele não é um tipo primitivo, nós declaramos ele com a inicial maiúscula. 

Também podemos concatenar strings com strings ou com outros tipos usando o sinal ``+``

#### Estrutura de decisão, famoso if 

O if no Java é igual ao C. Se a gente tiver somente uma ação para fazer depois de um if, a gente não precisa das chaves, mas é boa prática usar elas mesmo quando temos uma ação.

Também temos o else if, da mesma forma que temos no C. 

Exemplo: 

```java

if (idade >= 18) {
    System.out.println("Você tem mais de 18 anos, seja bem-vindo");
} else if (quantidadePessoas >= 2) {
    System.out.println("Você não tem 18 anos, mas pode entrar, pois está acompanhado");
} else {
    System.out.println("Infelizmente você não pode entrar");
}
```

#### Boolean, expressões booleanas e alguns operadores lógicos

O ``boolean`` é mais um tipo primitivo do Java. Esse tipo aceita somente duas coisas: ``true`` e ``false``. 

```java
boolean trueCondition = true;
boolean falseCondition = false; 
```

Podemos também colocar uma expressão booleana dentro de um boolean: 

```java
boolean peopleQuantity = 3;
boolean booleanExpression = peopleQuantity >= 2;
```

Se imprimirmos a variável booleanExpression, teremos o valor ``true`` como resposta. 

O que colocamos dentro dos parênteses de um ``if`` também é uma expressão booleana. Mesmo se não usarmos operadores lógicos, ainda é um boolean. 

```java
if (booleanExpression) {
    System.out.println("Bem-vindo");
} else {
    System.out.println("Você não pode entrar");
}
```

Quando colocamos só o nome da variável dentro do parênteses do ``if``, é a mesma coisa se colocassemos ``if (booleanExpression == true)``. 

Falamos de operadores lógicos um pouco mais acima. O Java também tem o operador ``||`` e ``&&``, igual ao C. `

#### Escopo de variáveis

Escopo nada mais é do que quando uma variável nasce e morre. Por exemplo: 

```java
public static void main (String[] args) {
    int primeiraVariavel = 1;
    int segundaVariavel = 2; 

    if (primeiraVariavel == 1) {
        boolean teste = true;
    } else {
        boolean teste = false; 
    }
}
```

As variáveis ``primeiraVariavel`` e ``segundaVariavel`` existem a partir da linha 212 e 213 respectivamente e morrem na linha ``220`` que é justamente onde tem a chave que fecha o ``public static void main``. Já a variável ``teste`` nasce a primeira vez na linha ``216`` e morre na linha seguinte, e nasce de novo na linha ``218`` e morre na linha seguinte, seguindo a mesma regra da anterior. Se eu tentar printar ``teste`` depois da linha ``219``, eu não vou conseguir porque ela não foi declarada dentro do escopo que ``sysout`` está. 

Obs: eu não criei o arquivo ``TestaEscopo`` no Eclipse porque achei melhor explicar aqui. 