
	


Algorithme implantÈ

-recuit simulÈ
-tabou

fonction objectif : retourne la qualitÈ du clavier evaluÈ comme ceci :
	somme de la qualitÈ de chaque touche (par rapport aux touche ‡ cotÈ) 
	la qualitÈ d'une touche est evaluÈ comme ceci :
	somme des bigramme de la touche avec celle du haut, du bas, de la gauche et de la droite (a condition de ne pas 
	etre sur un bord)



Deroulement du logiciel 

Les algorithmes implementÈs veulent maximiser la fonction objectif. Apres le choix du clavier de depart effÈctuÈ et le bouton 
executer pressÈ, une succession de clavier apparaissent, ils correspondent respectivement : 

- pour tabou
	‡ chaque maximum local tester dans l'ordre ou il sont tester (a la fin le meilleur est affichÈ) 
	
- pour recuit simulÈ
	‡ chaque voisin qui a amÈliorer l'objectif et donc au maximum en dernier.



Modelisation choisi

Tabou

taille de l'espace de recherche : 26 !  * (46 parmi 14)
mouvements possibles : on crÈe tous les successeur, clavier identique a par deux case contigue qui ont etait echangÈ
critere d'arret : l'algorithme s'arrete quand le cout cesse d'augmenter sur X claviers d'affilÈ X Ètant le parametre.


Recuit simulÈ

taille de l'espace de recherche : 26 !  * (46 parmi 14)
mouvements possibles : On choisit une permutation alÈatoire de deux lettres de notre clavier courant 
 critere d'arret : l'algorithme s'arrete quand la temperature a atteint 0.











































********************************************************************************************************************************************
********************************************************************************************************************************************
						           Ordonnancement d'un clavier
								√† l'aide de M√©taheuristique


Auteur : Jimmy Falck & Geoffrey Deremetz
********************************************************************************************************************************************
********************************************************************************************************************************************
						Algorithme implant√©s : 

- Recuit Simul√©

-Recherche Tabou

-Algorithme g√©n√©tique


********************************************************************************************************************************************
				Fonction Objectif : Minimaliser la distance entre chaque touches en s'appuyant sur l'analyse des bigrammes.
La formule utilis√© est obj = obj + bigramme[i][j] * c.distance(i, j) avec i,j [A-Z]


********************************************************************************************************************************************
********************************************************************************************************************************************

						Description de l'interface 


L'interface centrale permet de visualiser le clavier courant sur lequel va √™tre effectuer l'algorithme choissie.
A gauche, un rapport vous montre l'√©tat actuel de l'algorithme ainsi que les informations de celui-ci.

En bas, les algorithmes que vous pouvez tester sur le clavier ainsi 
que deux boutons : play et reset qui permettent de lancer l'animation ou de changer le clavier

********************************************************************************************************************************************

						Lancement : 

Pour lancer l'animation choissisez l'algorithme voulue et appuyez sur play. Si votre algorithme est fini, et que vous relancer l'algorithme,
 reexecutera sur le meme clavier que le precedent permettant de tester les differents algos sur le meme clavier.

********************************************************************************************************************************************
						Reinitialisez le clavier 

La reinitialisation permet de g√©n√©rer un nouveau Clavier.
********************************************************************************************************************************************
********************************************************************************************************************************************
						Deroulement du logiciel 

Les algorithmes implementes cherchent √† minimiser la distance entre les touches. Le logiciel va executer l'algorithme sur le clavier initial, 
une fois fini, les claviers g√©n√©res lros de l'algorithme vont apparaitre dans l'interface centrale avec pour information le cout et le 
meilleur cout obtenu jusqu'ici. A la fin, l'interface va montrer tout les claviers qui ont √©t√© utilis√©s comme meilleur clavier lors du d√©roulement.

********************************************************************************************************************************************
********************************************************************************************************************************************
					MODELISATION CHOISIE
********************************************************************************************************************************************

					RECUIT SIMULE
********************************************************************************************************************************************
taille de l'espace de recherche : 26 !  * (46 parmi 14)

mouvements possibles : On choisit une permutation al√©atoire de deux lettres de notre clavier courant 

 critere d'arret : l'algorithme s'arrete quand la temperature a atteint la temperature maximale pass√© en parametre.

********************************************************************************************************************************************

					RECHERCHE TABOU
********************************************************************************************************************************************
taille de l'espace de recherche : 26 !  * (46 parmi 14)

mouvements possibles : On cr√©er tout les successeurs de notre clavier courant et on recupere celui avec la meilleur fonction objectif.

 critere d'arret : l'algorithme s'arrete quand le cout cesse d'augmenter sur 100 claviers d'affil√©.


					ALGORITHME GENETIQUE
********************************************************************************************************************************************
taille de l'espace de recherche : 26 !  * (46 parmi 14)

mouvements possibles : On creer un groupe de X Claviers ( X pass√© en parametre ), on pioche au hasard deux Clavier dans ce groupe. On creer 
un nouveau clavier avec un melange de ces caracteristiques obtenus via les deux parents.

 critere d'arret : L'algorithme s'arrete quand le nombre de Clavier cr√©er est √©gale √† X * 10 

**********************************************************************************************************************************************
**********************************************************************************************************************************************
									RESULTATS OBTENUS

Pour chaque Algorithme, nos r√©sultats s'appuient sur le meme clavier initial  : 
				{ ' ', ' ', 'A', 'B', 'C', 'D', 'E', 'F', ' ', ' ' },
				{ ' ', ' ', 'G', 'H', 'I', 'J', 'K', 'L', ' ', ' ' },
				{ ' ', ' ', 'M', 'N', 'O', 'P', 'Q', 'R', ' ', ' ' },
				{ ' ', ' ', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' }, };

objectif initial =  340460

************************************************************************************************************************************************

									RECUIT SIMULE

 temperature Maximale 100 : 

				Clavier Obtenu avec un objectif de 209709

						| | |W|V|P|M|B|K| | |
						| |J|G|O|A|R|U|Q| | |
						| | |F|N|T|E|L|X|Z| |
						| | |H|C|I|S|D|Y| | |

 Temps : 0.276s 

Nombre d'etats generes : 2929
********************************************************************************************************************************************************
									RECHERCHE TABOU

Liste maximale = 100 

				Clavier Obtenu avec un objectif de 230960

						| | |W|V|P|M|B|K| | |
						| |J|G|O|A|R|U|Q| | |
						| | |F|N|T|E|L|X|Z| |
						| | |H|C|I|S|D|Y| | |

 Temps : 0.38s

Nombre d'etats generes : 123

********************************************************************************************************************************************************
									ALGORITHME GENETIQUE

probabilite de mutation : 50%
Population initale = 100

				Clavier Obtenu avec un objectif de 269718
							| | |F| |C|D|W|A| | |
							| |Z| | |N|R|I|M|G|B|
							| |H|J| |T|E|U|S|O|Q|
							| | | |P| |L|Y|X|V|K|


 Temps : 4.667s

Nombre d'etats generes : 1000

**********************************************************************************************************************************************
**********************************************************************************************************************************************
											AVIS 

A travers divers tests effectu√©s, nous remarquons que le plus perfomant dans notre cas est le recuit simul√© au niveau temps et precision. 

Le recuit simul√© permet des mouvements am√©liorateurs et qui am√©liore seulement une seule solution √† la fois ce qui permet 
une am√©lioration de recherche de notre solution optimale.

La recherche Tabou am√©liore aussi seulement une seule solution √† la fois cependant la recherche tabou chosie le meilleur voisin dans 
l'ensembles des solutions voisines ce qui augmente le temps au vu du domaine de recherche.

Tandis que l'algorithme genetique traite en parallele plusieurs configurations de la population et les solutions cr√©es n'ont peu de caracteristiques 
communes vu que la solution cr√©er est le resultat d'un croisement de deux soltuions al√©atoires. 

**********************************************************************************************************************************************
**********************************************************************************************************************************************
											MEILLEUR RESULTAT

Obtenu avec le recuit simul√© 
CLAVIER : objectif  208941 

 Temps : 1.547s

Nombre d'etats generes : 
17429

| |K|F|V|M|Q| | |W| |
| |J|O|I|R|U|B| | | |
| |G|N|T|E|S|D|X| | |
|Z|H|C|A|L|P|Y| | | |
**********************************************************************************************************************************************
**********************************************************************************************************************************************
											BIBLIOGRAPHIE/WEBOGRAPHIE


Les algorithmes ont √©t√© inspir√©s par le cours "Optimisation" disponible sur arche de l'universite de lorraine 
ainsi que le site http://en.wikipedia.org. 







