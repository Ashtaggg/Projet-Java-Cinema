-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le : lun. 25 mars 2024 à 10:09
-- Version du serveur : 5.7.36
-- Version de PHP : 7.4.26

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `projet-java-cinema`
--

-- --------------------------------------------------------

--
-- Structure de la table `compte`
--

DROP TABLE IF EXISTS `compte`;
CREATE TABLE IF NOT EXISTS `compte` (
  `ID_Compte` int(11) NOT NULL AUTO_INCREMENT,
  `Admin` int(11) NOT NULL COMMENT '0 -> Pas admin\r\n1 -> Admin',
  `Prenom` text NOT NULL,
  `Nom` text NOT NULL,
  `MotDePasse` text NOT NULL COMMENT 'hash256 du mdp',
  `DateNaissance` date NOT NULL,
  `PhotoProfil` text NOT NULL,
  `Mail` text NOT NULL,
  `Telephone` text NOT NULL,
  `Adresse` text NOT NULL,
  `Genre` int(11) NOT NULL COMMENT '0 -> Femme 1 -> Homme',
  `CarteNum` text NOT NULL,
  `CarteDate` text NOT NULL,
  `CarteCCV` int(11) NOT NULL,
  `CarteNom` text NOT NULL,
  PRIMARY KEY (`ID_Compte`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `compte`
--

INSERT INTO `compte` (`ID_Compte`, `Admin`, `Prenom`, `Nom`, `MotDePasse`, `DateNaissance`, `PhotoProfil`, `Mail`, `Telephone`, `Adresse`, `Genre`, `CarteNum`, `CarteDate`, `CarteCCV`, `CarteNom`) VALUES
(1, 1, 'Alexis', 'RAYNAL', '123', '2003-10-01', '', 'alexis.raynal@edu.ece.fr', '0769306674', '94', 1, '5218693280054780', '08/26', 451, 'Alexis RAYNAL'),
(2, 1, 'Anthony', 'SABBAGH', '123', '2003-10-04', '', 'anthony.sabbagh@edu.ece.fr', '0777456452', '78', 1, '4070497058946763', '10/24', 841, 'Anthony SABBAGH'),
(3, 1, 'Mathis', 'GRAS', '123', '2003-06-14', '', 'mathis.gras@edu.ece.fr', '0783292535', 'Perdu', 1, '5402405801318457', '01/25', 520, 'Mathis GRAS'),
(4, 0, 'Victor', 'LAMBERT', '123', '2003-01-12', '', 'victor.lambert@edu.ece.fr', '0789842625', '45', 0, '4514785630054954', '12/24', 120, 'Victor LAMBERT');

-- --------------------------------------------------------

--
-- Structure de la table `film`
--

DROP TABLE IF EXISTS `film`;
CREATE TABLE IF NOT EXISTS `film` (
  `ID_Film` int(11) NOT NULL AUTO_INCREMENT,
  `Nom` text NOT NULL,
  `Prix` float NOT NULL,
  `DateSortie` date NOT NULL,
  `Photo` text NOT NULL,
  `Duree` time NOT NULL,
  `Description` text NOT NULL,
  `Note` float NOT NULL COMMENT 'Note entre 0 et 5 étoiles',
  `4DX` int(11) NOT NULL COMMENT '0 -> Sans 4DX 1 -> 4DX',
  `Realisateur` text NOT NULL,
  `Acteur` text NOT NULL,
  `Synopsis` text NOT NULL,
  PRIMARY KEY (`ID_Film`)
) ENGINE=MyISAM AUTO_INCREMENT=36 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `film`
--

INSERT INTO `film` (`ID_Film`, `Nom`, `Prix`, `DateSortie`, `Photo`, `Duree`, `Description`, `Note`, `4DX`, `Realisateur`, `Acteur`, `Synopsis`) VALUES
(1, 'Fast & Furious', 10.99, '2001-09-26', '', '01:47:00', 'Action, Policier', 3, 0, 'Rob Cohen', 'Paul Walker, Vin Diesel, Michelle Rodriguez', 'La nuit tombée, Dominic Toretto règne sur les rues de Los Angeles à la tête d\'une équipe de fidèles qui partagent son goût du risque, sa passion de la vitesse et son culte des voitures de sport lancées à plus de 250 km/h dans des rodéos urbains d\'une rare violence. Ses journées sont consacrées à bricoler et à relooker des modèles haut de gamme, à les rendre toujours plus performants et plus voyants, à organiser des joutes illicites où de nombreux candidats s\'affrontent sans merci sous le regard énamouré de leurs groupies. A la suite de plusieurs attaques de camions, la police de L.A. décide d\'enquêter sur le milieu des street racers. Brian, un jeune policier, est chargé d\'inflitrer la bande de Toretto, qui figure, avec celle de son rival Johnny Tran, au premier rang des suspects.'),
(2, '2 Fast 2 Furious', 10.99, '2003-06-18', '', '01:45:00', 'Action, Aventure', 2.3, 0, 'John Singleton', 'Paul Walker, Tyrese Gibson, Eva Mendes', 'Brian O\'Conner a signé sa plus belle action, mais aussi sa faute la plus grave, en laissant filer le chef du gang de voleurs de voitures qu\'il avait mission d\'infiltrer. Radié de la police de Los Angeles, ce jeune flic rebelle, fan de vitesse et de rodéos, a gardé intact son honneur mais a gâché une belle carrière. Après deux ans de galère, Brian O\'Conner se retrouve à Miami et se voit offrir une ultime chance de se racheter.\r\n\r\nLe FBI et les douanes locales surveillent depuis plusieurs mois le puissant homme d\'affaires Carter Verone, qu\'ils soupçonnent de se livrer à des opérations de blanchiment d\'argent. Mais leurs efforts sont restés vains, le seul indice dont ils disposent pour appâter et démasquer l\'énigmatique criminel étant sa passion pour les rodéos. Le temps presse, Brian semble être le seul espoir...'),
(3, 'Fast & Furious : Tokyo Drift', 10.99, '2006-07-19', '', '01:44:00', 'Action, Policier', 1.6, 0, 'Justin Lin', 'Lucas Black, Shad Moss, Brian Tee', 'Sean Boswell est un risque-tout à qui sa passion immodérée des voitures de sport trafiquées a déjà attiré de sérieux ennuis avec la police californienne. Condamné après un accident, sa seule alternative à la prison est d\'accepter la tutelle de son père, militaire de carrière basé à Tokyo.\r\n\r\nGaijin (étranger) dans la ville la plus moderne et la plus sexy du monde, le jeune homme se sent plus exclu que jamais jusqu\'au jour où un nouveau copain, Twinkie, lui fait découvrir l\'univers secret du drifting - le nec plus ultra des rodéos urbains. Un sport clandestin où l\'audace, l\'élégance et la fluidité de la conduite sont encore plus appréciées que la simple vitesse.\r\n\r\nSean est immédiatement accroché : son style de vie rebelle a trouvé sa parfaite expression dans le drift, ses périlleuses transgressions, son défi permanent aux lois de la physique...'),
(4, 'Fast and Furious 4', 10.99, '2009-04-08', '', '01:40:00', 'Action', 2.3, 0, 'Justin Lin', 'Vin Diesel, Paul Walker, Jordana Brewster', 'Un meurtre oblige Don Toretto, un ancien taulard en cavale, et l\'agent Brian O\'Conner à revenir à L.A. où leur querelle se rallume. Mais confrontés à un ennemi commun, ils sont contraints à former une alliance incertaine s\'ils espèrent parvenir à déjouer ses plans. De l\'attaque de convoi aux glissades de précision qui les mèneront hors de leurs propres frontières, les deux hommes trouveront le meilleur moyen de prendre leur revanche : en poussant les limites de ce qui est faisable au volant d\'un bolide.'),
(5, 'Fast and Furious 5', 10.99, '2011-05-04', '', '02:10:00', 'Action, Thriller', 3.3, 0, 'Justin Lin', 'Vin Diesel, Paul Walker, Dwayne Johnson', 'Depuis que Brian et Mia Toretto ont extirpé Dom des mains de la justice, ils ont dû franchir de nombreuses frontières pour échapper aux autorités. Retirés à Rio, ils sont contraints de monter un dernier coup pour se faire blanchir et recouvrer leur liberté. Ils se constituent une équipe d\'élite, réunissant les pilotes les plus avertis, conscients que leur seule chance d\'être acquittés pour bonne conduite nécessite une confrontation avec l\'homme d\'affaires véreux qui souhaite les voir morts. Mais il n\'est pas le seul à leurs trousses. L\'impitoyable agent fédéral Luke Hobbs n\'a jamais loupé sa cible. Affecté à la traque des fugitifs, lui et son équipe de choc élaborent un implacable dispositif d\'assaut destiné à les capturer. Passant le Brésil au crible, Hobbs réalise combien la frontière qui sépare les bons des méchants est ténue. Il doit alors s\'en remettre à son instinct pour acculer ses proies et éviter qu\'un autre ne les débusque avant lui.'),
(6, 'Fast & Furious 6', 10.99, '2013-05-22', '', '02:10:00', 'Action', 3, 0, 'Justin Lin', 'Vin Diesel, Paul Walker, Dwayne Johnson', 'Dom, Brian et toute leur équipe, après le casse de Rio, ayant fait tomber un empire en empochant 100 millions de dollars, se sont dispersés aux quatre coins du globe. Mais l’incapacité de rentrer chez eux, et l’obligation de vivre en cavale permanente, laissent à leur vie le goût amer de l’inaccomplissement. Pendant ce temps Hobbs traque aux quatre coins du monde un groupe de chauffeurs mercenaires aux talents redoutables, dont le meneur, Shaw est secondé d’une de main de fer par l’amour que Dom croyait avoir perdu pour toujours : Letty. La seule façon d’arrêter leurs agissements est de les détrôner en surpassant leur réputation. Hobbs demande donc à Dom de rassembler son équipe de choc à Londres. En retour ? Ils seront tous graciés et pourront retourner auprès des leurs, afin de vivre une vie normale.'),
(7, 'Fast & Furious 7', 10.99, '2015-04-01', '', '02:17:00', 'Action', 3.6, 0, 'James Wan', 'Vin Diesel, Paul Walker, Jason Statham', 'Dominic Toretto et sa \"famille\" doivent faire face à Deckard Shaw, bien décidé à se venger de la mort de son frère.'),
(8, 'Fast & Furious 8', 10.99, '2017-04-12', '', '02:16:00', 'Action, Thriller', 3.1, 0, 'F. Gary Gray', 'Vin Diesel, Dwayne Johnson, Jason Statham', 'Maintenant que Dom et Letty sont en lune de miel, que Brian et Mia se sont rangés et que le reste de l’équipe a été disculpé, la bande de globetrotteurs retrouve un semblant de vie normale. Mais quand une mystérieuse femme entraîne Dom dans le monde de la criminalité, ce dernier ne pourra éviter de trahir ses proches qui vont faire face à des épreuves qu’ils n’avaient jamais rencontrées jusqu’alors.\r\n\r\nDes rivages de Cuba au rues de New York en passant par les plaines gelées de la mer arctique de Barrents, notre équipe va sillonner le globe pour tenter d\'empêcher une anarchiste de déchaîner un chaos mondial et de ramener à la maison l’homme qui a fait d’eux une famille.'),
(9, 'Fast & Furious 9', 10.99, '2021-07-14', '', '02:23:00', 'Action', 2.7, 0, 'Justin Lin', 'Vin Diesel, Michelle Rodriguez, Jordana Brewster', 'Si Dom Toretto mène une vie tranquille, loin du bitume, auprès de Letty et de leur fils, le petit Brian, ils savent bien tous les deux que derrière les horizons les plus radieux se cachent toujours les dangers les plus sournois. Cette fois, pour sauver ceux à qui il tient le plus, Dom va devoir affronter les démons de son passé. Son équipe se rassemble pour démanteler un complot à échelle mondiale mené par le tueur le plus implacable qu’ils aient jamais affronté, aussi redoutable avec une arme que derrière un volant : Un homme qui n’est autre que le frère désavoué de Dom, Jakob.'),
(10, 'Fast & Furious X', 24.99, '2023-05-17', '', '02:21:00', 'Action', 2.8, 1, 'Louis Leterrier', 'Vin Diesel, Michelle Rodriguez, Jason Momoa', 'Après bien des missions et contre toute attente, Dom Toretto et sa famille ont su déjouer, devancer, surpasser et distancer tous les adversaires qui ont croisé leur route. Ils sont aujourd’hui face à leur ennemi le plus terrifiant et le plus intime : émergeant des brumes du passé, ce revenant assoiffé de vengeance est bien déterminé à décimer la famille en réduisant à néant tout ce à quoi, et surtout à qui Dom ait jamais tenu.\r\n\r\nDans FAST & FURIOUS 5 en 2011, Dom et son équipe avaient fait tomber l’infâme ponte de la drogue brésilienne, Hernan Reyes, en précipitant son empire du haut d’un pont de Rio De Janeiro. Ils étaient loin de se douter que son fils Dante, avait assisté impuissant à la scène et qu’il avait passé ces douze dernières années à échafauder le plan infernal qui exigerait de Dom un prix ultime.\r\n\r\nDante va débusquer et traquer Dom et sa famille aux quatre coins du monde, de Los Angeles aux catacombes de Rome, du Brésil à Londres et de l’Antarctique au Portugal. De nouvelles alliances vont se forger et de vieux ennemis réapparaitre. Mais tout va basculer quand Dom va comprendre que la cible principale de Dante n’est autre que son fils à peine âgé de 8 ans.'),
(11, 'Fast & Furious : Hobbs & Shaw', 10.99, '2019-08-07', '', '02:16:00', 'Action', 2.8, 0, 'David Leitch', 'Dwayne Johnson, Jason Statham, Idris Elba', 'Depuis que Hobbs, fidèle agent de sécurité au service diplomatique des Etats-Unis, combatif mais droit, et Shaw, un homme sans foi ni loi, ancien membre de l’élite militaire britannique, se sont affrontés en 2015 dans Fast & Furious 7 ; les deux hommes font tout ce qu’ils peuvent pour se nuire l’un à l’autre.\r\n\r\nMais lorsque Brixton, un anarchiste génétiquement modifié, met la main sur une arme de destruction massive après avoir battu le meilleur agent du MI6 qui se trouve être la sœur de Shaw. Les deux ennemis de longue date vont devoir alors faire équipe pour faire tomber le seul adversaire capable de les anéantir. '),
(12, 'Barbie', 10.99, '2023-07-19', '', '01:55:00', 'Aventure, Comédie, Famille', 3.5, 0, 'Greta Gerwig', 'Margot Robbie, Ryan Gosling, America Ferrera', 'A Barbie Land, vous êtes un être parfait dans un monde parfait. Sauf si vous êtes en crise existentielle, ou si vous êtes Ken.'),
(13, 'Oppenheimer', 10.99, '2023-07-19', '', '03:01:00', 'Biopic, Historique, Thriller', 3.8, 0, 'Christopher Nolan', 'Cillian Murphy, Emily Blunt, Matt Damon', 'En 1942, convaincus que l’Allemagne nazie est en train de développer une arme nucléaire, les États-Unis initient, dans le plus grand secret, le \"Projet Manhattan\" destiné à mettre au point la première bombe atomique de l’histoire. Pour piloter ce dispositif, le gouvernement engage J. Robert Oppenheimer, brillant physicien, qui sera bientôt surnommé \"le père de la bombe atomique\". C’est dans le laboratoire ultra-secret de Los Alamos, au cœur du désert du Nouveau-Mexique, que le scientifique et son équipe mettent au point une arme révolutionnaire dont les conséquences, vertigineuses, continuent de peser sur le monde actuel…'),
(14, 'Avatar', 10.99, '2009-12-16', '', '02:42:00', 'Aventure, Science Fiction', 4.3, 0, 'James Cameron', 'Sam Worthington, Zoe Saldana, Sigourney Weaver', 'Malgré sa paralysie, Jake Sully, un ancien marine immobilisé dans un fauteuil roulant, est resté un combattant au plus profond de son être. Il est recruté pour se rendre à des années-lumière de la Terre, sur Pandora, où de puissants groupes industriels exploitent un minerai rarissime destiné à résoudre la crise énergétique sur Terre. Parce que l\'atmosphère de Pandora est toxique pour les humains, ceux-ci ont créé le Programme Avatar, qui permet à des \" pilotes \" humains de lier leur esprit à un avatar, un corps biologique commandé à distance, capable de survivre dans cette atmosphère létale. Ces avatars sont des hybrides créés génétiquement en croisant l\'ADN humain avec celui des Na\'vi, les autochtones de Pandora.\r\n\r\nSous sa forme d\'avatar, Jake peut de nouveau marcher. On lui confie une mission d\'infiltration auprès des Na\'vi, devenus un obstacle trop conséquent à l\'exploitation du précieux minerai. Mais tout va changer lorsque Neytiri, une très belle Na\'vi, sauve la vie de Jake...'),
(15, 'Avatar : la voie de l\'eau', 24.99, '2022-12-14', '', '03:12:00', 'Action, Aventure, Fantastique, Science Fiction', 4.1, 1, 'James Cameron', 'Sam Worthington, Zoe Saldana, Sigourney Weaver', 'Se déroulant plus d’une décennie après les événements relatés dans le premier film, AVATAR : LA VOIE DE L’EAU raconte l\'histoire des membres de la famille Sully (Jake, Neytiri et leurs enfants), les épreuves auxquelles ils sont confrontés, les chemins qu’ils doivent emprunter pour se protéger les uns les autres, les batailles qu’ils doivent mener pour rester en vie et les tragédies qu\'ils endurent.'),
(16, 'Dune', 10.99, '2021-09-15', '', '02:36:00', 'Drame, Science Fiction', 4, 0, 'Denis Villeneuve', 'Timothée Chalamet, Rebecca Ferguson, Oscar Isaac', 'L\'histoire de Paul Atreides, jeune homme aussi doué que brillant, voué à connaître un destin hors du commun qui le dépasse totalement. Car s\'il veut préserver l\'avenir de sa famille et de son peuple, il devra se rendre sur la planète la plus dangereuse de l\'univers – la seule à même de fournir la ressource la plus précieuse au monde, capable de décupler la puissance de l\'humanité. Tandis que des forces maléfiques se disputent le contrôle de cette planète, seuls ceux qui parviennent à dominer leur peur pourront survivre…'),
(17, 'Dune : Deuxième Partie', 24.99, '2024-02-28', '', '02:46:00', 'Drame, Science Fiction', 4.2, 1, 'Denis Villeneuve', 'Timothée Chalamet, Zendaya, Rebecca Ferguson', 'Dans DUNE : DEUXIÈME PARTIE, Paul Atreides s’unit à Chani et aux Fremen pour mener la révolte contre ceux qui ont anéanti sa famille. Hanté par de sombres prémonitions, il se trouve confronté au plus grand des dilemmes : choisir entre l’amour de sa vie et le destin de l’univers.'),
(18, 'Interstellar', 10.99, '2014-11-05', '', '02:49:00', 'Drame, Science Fiction', 3.8, 0, 'Christopher Nolan', 'Matthew McConaughey, Anne Hathaway, Michael Caine', 'Le film raconte les aventures d’un groupe d’explorateurs qui utilisent une faille récemment découverte dans l’espace-temps afin de repousser les limites humaines et partir à la conquête des distances astronomiques dans un voyage interstellaire. '),
(19, 'Jurassic Park', 10.99, '1993-10-20', '', '02:02:00', 'Aventure, Science Fiction', 3.4, 0, 'Steven Spielberg', 'Sam Neill, Laura Dern, Jeff Goldblum', 'Ne pas réveiller le chat qui dort... C\'est ce que le milliardaire John Hammond aurait dû se rappeler avant de se lancer dans le \"clonage\" de dinosaures. C\'est à partir d\'une goutte de sang absorbée par un moustique fossilisé que John Hammond et son équipe ont réussi à faire renaître une dizaine d\'espèces de dinosaures. Il s\'apprête maintenant avec la complicité du docteur Alan Grant, paléontologue de renom, et de son amie Ellie, à ouvrir le plus grand parc à thème du monde. Mais c\'était sans compter la cupidité et la malveillance de l\'informaticien Dennis Nedry, et éventuellement des dinosaures, seuls maîtres sur l\'île...'),
(20, 'Le Monde Perdu : Jurassic Park', 10.99, '1997-10-22', '', '02:09:00', 'Aventure, Fantastique', 3.7, 0, 'Steven Spielberg', 'Jeff Goldblum, Richard Attenborough, Pete Postlethwaite', 'Quatre ans après le terrible fiasco de son Jurassic Park, le milliardaire John Hammond rappelle le Dr Ian Malcolm pour l\'informer de son nouveau projet. Sur une île déserte, voisine du parc, vivent en liberté des centaines de dinosaures de toutes tailles et de toutes espèces. Ce sont des descendants des animaux clônes en laboratoire. D\'abord réticent, Ian se décide à rejoindre le docteur quand il apprend que sa fiancée fait partie de l\'expédition scientifique. Il ignore qu\'une autre expédition qui n\'a pas les mêmes buts est également en route.'),
(21, 'Jurassic Park III', 10.99, '2001-08-08', '', '01:32:00', 'Action, Aventure, Science Fiction', 2.9, 0, 'Joe Johnston', 'Sam Neill, Alessandro Nivola, William H. Macy', 'Huit ans après les événements surréalistes survenus lors de sa visite au Jurassic Park du richissime John Hammond, le paléontologue Alan Grant se rappelle toujours de sa rencontre, d\'abord magique puis effroyable, avec ces dinosaures ramenés à la vie grâce aux incroyables progrès de la génétique. À l\'origine, ces créatures de la Préhistoire n\'étaient pas censées se reproduire ni survivre, mais elles ont déjoué les plans des scientifiques. Elles sont probablement toujours en vie sur l\'île Isla Sorna.Alan étudie l\'intelligence des vélociraptors. Cependant, il manque de subventions pour financer ses recherches. Paul Kirby et sa femme Amanda, un couple richissime, lui proposent alors une grosse somme d\'argent s\'il leur fait survoler la fameuse île. Alan accepte leur offre.Mais celui-ci flaire une entourloupe lorsque le pilote amorce sa descente sur l\'île. Il découvre alors les vraies raisons de l\'excursion organisée par les Kirby : sauver Eric, leur fils disparu dans les environs. Ces derniers avaient besoin de son aide, car il est le seul à connaître l\'île et ses mystérieux occupants. Cependant, au moment où l\'avion s\'apprête à redécoller, un spinosaure tente de piétiner l\'appareil...'),
(22, 'Jurassic World', 10.99, '2015-06-10', '', '02:05:00', 'Action, Aventure, Science Fiction', 2.9, 0, 'Colin Trevorrow', 'Chris Pratt, Bryce Dallas Howard, Nick Robinson', 'L\'Indominus Rex, un dinosaure génétiquement modifié, pure création de la scientifique Claire Dearing, sème la terreur dans le fameux parc d\'attraction. Les espoirs de mettre fin à cette menace reptilienne se portent alors sur le dresseur de raptors Owen Grady et sa cool attitude.'),
(23, 'Deadpool', 10.99, '2016-02-10', '', '01:48:00', 'Action, Comédie', 3.1, 0, 'Tim Miller', 'Ryan Reynolds, Morena Baccarin, Ed Skrein', 'Deadpool, est l\'anti-héros le plus atypique de l\'univers Marvel. A l\'origine, il s\'appelle Wade Wilson : un ancien militaire des Forces Spéciales devenu mercenaire. Après avoir subi une expérimentation hors norme qui va accélérer ses pouvoirs de guérison, il va devenir Deadpool. Armé de ses nouvelles capacités et d\'un humour noir survolté, Deadpool va traquer l\'homme qui a bien failli anéantir sa vie.'),
(24, 'Deadpool 2', 10.99, '2018-05-16', '', '02:00:00', 'Action, Aventure, Comédie', 3.1, 0, 'David Leitch', 'Ryan Reynolds, Josh Brolin, Morena Baccarin', 'L’insolent mercenaire de Marvel remet le masque !\r\n\r\nPlus grand, plus-mieux, et occasionnellement les fesses à l’air, il devra affronter un Super-Soldat dressé pour tuer, repenser l’amitié, la famille, et ce que signifie l’héroïsme – tout en bottant cinquante nuances de culs, car comme chacun sait, pour faire le Bien, il faut parfois se salir les doigts.'),
(25, 'Le Mans 66', 10.99, '2019-11-13', '', '02:33:00', 'Biopic, Drame', 3.8, 0, 'James Mangold', 'Matt Damon, Christian Bale, Caitriona Balfe', 'Basé sur une histoire vraie, le film suit une équipe d\'excentriques ingénieurs américains menés par le visionnaire Carroll Shelby et son pilote britannique Ken Miles, qui sont envoyés par Henry Ford II pour construire à partir de rien une nouvelle automobile qui doit détrôner la Ferrari à la compétition du Mans de 1966.'),
(26, 'Avengers', 10.99, '2012-04-25', '', '02:23:00', 'Action, Aventure, Science Fiction', 4, 0, 'Joss Whedon', 'Robert Downey Jr., Chris Evans, Mark Ruffalo', 'Lorsque Nick Fury, le directeur du S.H.I.E.L.D., l\'organisation qui préserve la paix au plan mondial, cherche à former une équipe de choc pour empêcher la destruction du monde, Iron Man, Hulk, Thor, Captain America, Hawkeye et Black Widow répondent présents.\r\n\r\nLes Avengers ont beau constituer la plus fantastique des équipes, il leur reste encore à apprendre à travailler ensemble, et non les uns contre les autres, d\'autant que le redoutable Loki a réussi à accéder au Cube Cosmique et à son pouvoir illimité...'),
(27, 'Avengers : L\'ère d\'Ultron', 10.99, '2015-04-22', '', '02:21:00', 'Action, Aventure, Fantastique', 2.9, 0, 'Joss Whedon', 'Robert Downey Jr., Chris Evans, Mark Ruffalo', 'Alors que Tony Stark tente de relancer un programme de maintien de la paix jusque-là suspendu, les choses tournent mal et les super-héros Iron Man, Captain America, Thor, Hulk, Black Widow et Hawkeye vont devoir à nouveau unir leurs forces pour combattre le plus puissant de leurs adversaires : le terrible Ultron, un être technologique terrifiant qui s’est juré d’éradiquer l’espèce humaine.\r\n\r\nAfin d’empêcher celui-ci d’accomplir ses sombres desseins, des alliances inattendues se scellent, les entraînant dans une incroyable aventure et une haletante course contre le temps…'),
(28, 'Avengers : Infinity War', 10.99, '2018-04-25', '', '02:36:00', 'Action, Aventure, Science Fiction', 3.4, 0, 'Joe Russo', 'Robert Downey Jr., Chris Hemsworth, Mark Ruffalo', 'Les Avengers et leurs alliés devront être prêts à tout sacrifier pour neutraliser le redoutable Thanos avant que son attaque éclair ne conduise à la destruction complète de l’univers.'),
(29, 'Avengers: Endgame', 10.99, '2019-04-24', '', '03:01:00', 'Action, Aventure, Science Fiction', 3.2, 0, 'Joe Russo', 'Robert Downey Jr., Chris Evans, Mark Ruffalo', 'Thanos ayant anéanti la moitié de l’univers, les Avengers restants resserrent les rangs dans ce vingt-deuxième film des Studios Marvel, grande conclusion d’un des chapitres de l’Univers Cinématographique Marvel.'),
(30, 'Baywatch - Alerte à Malibu', 10.99, '2017-06-21', '', '01:57:00', 'Action, Comédie', 1.8, 0, 'Seth Gordon', 'Dwayne Johnson, Zac Efron, Alexandra Daddario', 'Le légendaire sauveteur Mitch Buchannon  est contraint de s’associer à une nouvelle recrue, Matt Brody, aussi ambitieux que tête brûlée ! Ensemble, ils vont tenter de déjouer un complot criminel qui menace l\'avenir de la Baie…'),
(31, 'Fight Club', 10.99, '1999-11-10', '', '02:19:00', 'Drame, Thriller', 2.7, 0, 'David Fincher', 'Brad Pitt, Edward Norton, Helena Bonham Carter', 'Le narrateur, sans identité précise, vit seul, travaille seul, dort seul, mange seul ses plateaux-repas pour une personne comme beaucoup d\'autres personnes seules qui connaissent la misère humaine, morale et sexuelle. C\'est pourquoi il va devenir membre du Fight club, un lieu clandestin ou il va pouvoir retrouver sa virilité, l\'échange et la communication. Ce club est dirigé par Tyler Durden, une sorte d\'anarchiste entre gourou et philosophe qui prêche l\'amour de son prochain.'),
(32, 'Astérix et Obélix : Mission Cléopâtre', 10.99, '2002-01-30', '', '01:52:00', 'Comédie', 3.8, 0, 'Alain Chabat', 'Gérard Depardieu, Christian Clavier, Jamel Debbouze', 'Cléopâtre, la reine d’Égypte, décide, pour défier l\'Empereur romain Jules César, de construire en trois mois un palais somptueux en plein désert. Si elle y parvient, celui-ci devra concéder publiquement que le peuple égyptien est le plus grand de tous les peuples. Pour ce faire, Cléopâtre fait appel à Numérobis, un architecte d\'avant-garde plein d\'énergie. S\'il réussit, elle le couvrira d\'or. S\'il échoue, elle le jettera aux crocodiles.\r\n\r\nCelui-ci, conscient du défi à relever, cherche de l\'aide auprès de son vieil ami Panoramix. Le druide fait le voyage en Égypte avec Astérix et Obélix. De son côté, Amonbofis, l\'architecte officiel de Cléopâtre, jaloux que la reine ait choisi Numérobis pour construire le palais, va tout mettre en œuvre pour faire échouer son concurrent.'),
(33, 'OSS 117, Le Caire nid d\'espions', 10.99, '2006-04-19', '', '01:39:00', 'Action, Comédie, Espionnage', 3.9, 0, 'Michel Hazanavicius', 'Jean Dujardin, Bérénice Bejo, Aure Atika', 'Égypte, 1955, le Caire est un véritable nid d\'espions.\r\n\r\nTout le monde se méfie de tout le monde, tout le monde complote contre tout le monde : Anglais, Français, Soviétiques, la famille du Roi déchu Farouk qui veut retrouver son trône, les Aigles de Kheops, secte religieuse qui veut prendre le pouvoir. Le Président de la République Française, Monsieur René Coty, envoie son arme maîtresse mettre de l\'ordre dans cette pétaudière au bord du chaos : Hubert Bonisseur de la Bath, dit OSS 117.'),
(34, 'OSS 117 : Rio ne répond plus', 10.99, '2009-04-15', '', '01:40:00', 'Comédie, Espionnage', 4.1, 0, 'Michel Hazanavicius', 'Jean Dujardin, Louise Monot, Rüdiger Vogler', 'Douze ans après Le Caire, OSS 117 est de retour pour une nouvelle mission à l\'autre bout du monde. Lancé sur les traces d\'un microfilm compromettant pour l\'Etat français, le plus célèbre de nos agents va devoir faire équipe avec la plus séduisante des lieutenants-colonels du Mossad pour capturer un nazi maître chanteur. Des plages ensoleillées de Rio aux luxuriantes forêts amazoniennes, des plus profondes grottes secrètes au sommet du Christ du Corcovado, c\'est une nouvelle aventure qui commence. Quel que soit le danger, quel que soit l\'enjeu, on peut toujours compter sur Hubert Bonisseur de la Bath pour s\'en sortir...'),
(35, 'OSS 117: Alerte rouge en Afrique noire', 10.99, '2021-08-04', '', '01:56:00', 'Aventure, Comédie, Espionnage', 2.8, 0, 'Nicolas Bedos', 'Jean Dujardin, Pierre Niney, Fatou N\'Diaye', '1981. Hubert Bonisseur de La Bath, alias OSS 117, est de retour. Pour cette nouvelle mission, plus délicate, plus périlleuse et plus torride que jamais, il est contraint de faire équipe avec un jeune collègue, le prometteur OSS 1001.');

-- --------------------------------------------------------

--
-- Structure de la table `reservation`
--

DROP TABLE IF EXISTS `reservation`;
CREATE TABLE IF NOT EXISTS `reservation` (
  `ID_Reservation` int(11) NOT NULL AUTO_INCREMENT,
  `ID_Compte` int(11) NOT NULL,
  `ID_Seance` int(11) NOT NULL,
  `NombrePlace` int(11) NOT NULL,
  `PrixTotal` int(11) NOT NULL,
  PRIMARY KEY (`ID_Reservation`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `salle`
--

DROP TABLE IF EXISTS `salle`;
CREATE TABLE IF NOT EXISTS `salle` (
  `ID_Salle` int(11) NOT NULL AUTO_INCREMENT,
  `NombrePlace` int(11) NOT NULL,
  `Etage` int(11) NOT NULL,
  `4DX` int(11) NOT NULL COMMENT '0 -> Sans 4DX 1 -> 4DX',
  PRIMARY KEY (`ID_Salle`)
) ENGINE=MyISAM AUTO_INCREMENT=35 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `salle`
--

INSERT INTO `salle` (`ID_Salle`, `NombrePlace`, `Etage`, `4DX`) VALUES
(10, 195, 1, 0),
(11, 241, 1, 0),
(12, 195, 1, 0),
(13, 248, 1, 0),
(14, 195, 1, 0),
(15, 255, 1, 0),
(16, 160, 1, 1),
(17, 135, 1, 1),
(20, 195, 2, 0),
(21, 353, 2, 0),
(22, 195, 2, 0),
(23, 353, 2, 0),
(24, 195, 2, 0),
(30, 195, 3, 0),
(31, 446, 3, 0),
(32, 195, 3, 0),
(33, 446, 3, 0),
(34, 195, 3, 0);

-- --------------------------------------------------------

--
-- Structure de la table `seance`
--

DROP TABLE IF EXISTS `seance`;
CREATE TABLE IF NOT EXISTS `seance` (
  `ID_Seance` int(11) NOT NULL AUTO_INCREMENT,
  `ID_Film` int(11) NOT NULL,
  `ID_Salle` int(11) NOT NULL,
  `Date` date NOT NULL,
  `Heure` time NOT NULL,
  `PlaceDisponible` int(11) NOT NULL,
  PRIMARY KEY (`ID_Seance`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
