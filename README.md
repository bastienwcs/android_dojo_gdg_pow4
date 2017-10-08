# Puissance 4

Le but est d’implémenter le jeu du puissance 4.

Règle du jeu : alternativement, chaque joueur dépose un jeton dans une colonne, qui se dépose le plus bas possible. Un joueur gagne s'il a 4 jetons alignés, horizontalement, verticalement ou en diagonale.

Les tests unitaires sont déjà en place, il va vous falloir coder la méthode play, qui retourne après chaque coup :

* 1 si le joueur 1 gagne
* 2 si le joueur 2 gagne
* 0 si personne ne gagne

Si un joueur joue deux fois d'affilé, une exception doit être levée.
Si le nombre de jetons dépasse le contenu d'une colonne, une exception doit être levée.

    javac -cp .:junit-4.12.jar ConnectFourTest.java
    java -cp .:junit-4.12.jar:hamcrest-core-1.3.jar org.junit.runner.JUnitCore ConnectFourTest
