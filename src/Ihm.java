import clavier.In;

public class Ihm {
    public static void main(String[] args) {
        String telephone, region = "", zone = "", type, pays = "France";
        String telP1, telP2;


        /*
        VARAIBLE type
        fixe => téléphone fixe
        mobile => téléphone mobile
        ip => télépone VOIP
        ngeo => téléphone non géographique
        }*/

        //Input
        System.out.print("Entrez votre numéro de téléphone : ");
        telephone = In.readString();


        if (telephone.charAt(0) == '+') {
            telephone = telephone.substring(1);
            if (telephone.length() == 11) {
                switch (telephone.charAt(1)) {
                    case '1':
                        pays = "Canada/Amercia";
                        break;
                    case '7':
                        pays = "Kazakhstan/Russie";
                        break;
                }
            }

            switch (telephone.substring(0, 2)) {
                case "20":
                    pays = "Egypte";
                    break;
                case "27":
                    pays = "Afrique du sud";
                    break;
                case "30":
                    pays = "Grèce";
                    break;
                case "33":
                    pays = "France";
                    break;
            }
            telephone = "0" + telephone.substring(2);
        }

        if (!pays.equals("France")) {
            System.out.println("Ce numero de téléphone vient de " + pays);
            return;
        }

        telP1 = telephone.substring(0, 2);
        telP2 = telephone.substring(2, 4);

        switch (telP1) {
            case "01":
                type = new String("fixe");
                region = new String("parisienne");
                switch (telP2) {
                    case "34", "39":
                        zone = new String("Yvelines");
                        break;
                    case "40":
                        zone = new String("Paris");
                        break;
                    default:
                        zone = new String("Non géré");
                }
                break;
            case "02":
                type = new String("fixe");
                region = new String("Nord Ouest");
                break;
            case "03":
                type = new String("fixe");
                region = new String("Nord Est");
                break;
            case "04":
                type = new String("fixe");
                region = new String("Sud Est");
                switch (telP2) {
                    case "75":
                        zone = new String("Drôme/Ardèche");
                        break;
                    default:
                        zone = new String("Non géré");
                }
                break;
            case "05":
                type = new String("fixe");
                region = new String("Sud Ouest");
                break;
            case "06":
                type = new String("mobile");
                switch (telP2) {
                    case "01":
                        zone = new String("Neuf Cegetel");
                        break;
                    case "03", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23",
                         "24", "25", "26", "27", "28", "29":
                        zone = new String("SFR");
                        break;
                    case "05":
                        zone = new String("Auchan Télécom");
                        break;
                    case "07", "08", "30", "31", "32", "33", "34", "35", "36":
                        zone = new String("Orange");
                        break;
                }
                break;
            case "07":
                type = new String("mobile");
                zone = new String("");
                break;
            case "08":
                type = new String("ngeo");
                switch (telP2) {
                    case "00", "01", "02", "03", "04", "05":
                        zone = new String("numéro verts (gratuit)");
                        break;
                    case "06", "07", "08", "09":
                        zone = new String("(gratuit)");
                        break;
                    case "10", "11", "12", "13", "14", "15", "16", "17", "18", "19":
                        zone = new String("vous paierez au maximum 6 centimes d’euros la minute, ou 15 centimes d’euros l’appel");
                        break;
                    case "20", "21", "22", "23", "24", "25", "26", "27", "28", "29":
                        zone = new String("vous paierez au maximum 20 centimes d’euro par minute, ou 50 centimes d’euros par appel");
                        break;
                    case "90", "91", "92", "93", "94", "95", "96", "97", "98", "99":
                        zone = new String("vous paierez au maximum 80 centimes d’euros par minute ou 3 euros par appel");
                        break;
                }
                break;
            case "09":
                type = new String("ip");
                break;
            default:
                System.out.println("\rVotre numéro de téléphone n'est pas surpporté par ce logiciel");
                return;
        }

        System.out.print("Votre numéro " + telephone);
        switch (type) {
            case "fixe":
                System.out.println(" est localisé en region " + region + " dans la zone " + zone);
                break;
            case "mobile":
                System.out.print(" est un numéro mobile");
                if (!zone.isEmpty()) {
                    System.out.println(" de l'opérateur " + zone);
                }
                break;
            case "ip":
                System.out.println("est un numéro VOIP");
                break;
            case "ngeo":
                System.out.println("est un numéro non gépgraphique, " + zone);
                break;
            default:
        }
    }
}
