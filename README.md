
# imdbAPI
<h2>#7DaysOfCode</h2>
<b>O desafio:</b><br>
Durante os 7 Days de Java, você vai praticar algo que além de importantíssimo, será muito divertido. 
Você irá utilizar apenas APIs do Java para consumir uma API, puxando o ranking dos top 250 filmes do IMDB e devolvendo um JSON.
Posteriormente, você irá começar a organizar uma modelagem que trabalhe com filmes (e talvez séries também) usando classes e interfaces.
Você também terá que trabalhar com construtores, abstrações, comparadores, entre muitos outros conceitos que colocarão à prova os seus conhecimentos de Java.
<br>
<h3>Algumas reflexões</h3>
<li><b>Você acha que faz sentido ter setters ou um construtor padrão?</b></li>
<p>Acho que faz mais sentido ter um construtor padrão, pois isso nos ajuda a encapsular melhor nosso objeto.</p>
<li><b>Um filme deve ser interfaceado?</b></li>
<p>Não vi um motivo para isso, mas caso quisessemos separar por generos, faria sentido sim.</p>
<li><b>Deve ser imutável?</b></li>
<p>Sim, pois filmes não costumam mudar de nome ao decorrer do tempo, e também não faz sentido mudarmos sua data de lançamento ou avaliação.</p>

<h3>Alguns pontos que quero compartilhar</h3>
<p>Optei em usar o padrão builder, para aproveitar o maximo dos recursos oferecidos pela programação orientada a objetos.
E também para encapsular o objeto principal, tornando-o imutavel, assim, para corrigirmos algum erro de digitação, será necessario
excluir o objeto atual (método ainda não implementado até o momento), e cadastra-lo novamente.</p>

<br>
<br>
<b>Participe você também</b>: https://7daysofcode.io/matricula/java
