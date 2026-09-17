import clavier.In;

public class Ihm {
    public static void main(String[] args) {
        String telephone, region="", zone = "",type;
        String telP1, telP2;

        //Input
        System.out.print("Entrez votre numéro de téléphone : ");
        telephone = In.readString();

        //Verif input
        if (telephone.length() != 10) {
            System.out.println("Entrez un numéro de téléphone valide !");
            return;
        }

        telP1 = telephone.substring(0, 2);
        telP2 = telephone.substring(2, 4);

        switch (telP1) {
            case "01":
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
                region = new String("Nord Ouest");
                break;
            case "03":
                region = new String("Nord Est");
                break;
            case "04":
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
            case "mobile":
                System.out.print(" est un numéro mobile");
                if (!zone.isEmpty()) {
                    System.out.println(" de l'opérateur " + zone);
                }
            case "ip":
                System.out.println("est un numéro VOIP");
            default:
        }
    }
}
