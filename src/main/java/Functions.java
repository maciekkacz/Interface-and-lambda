import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Functions<S, S1> {
    public static void main(String[] args) {
        Function<String, String> func = text -> text.toLowerCase().trim();
        String original = "   WIELKI NAPIS   ";
        // wywołujemy funkcję przekazując jej original jako argument
        String lowerCaseTrim = func.apply( original );
        System.out.println( lowerCaseTrim );

        String napis = "Polska Gola";
        System.out.println();

        Consumer<String> consumer = s -> {
            int loops = 3;
            for (int i = 0; i < 3; i++) {
                System.out.println( s );

            }
        };
        consumer.accept( napis );
        int personAge = 19;
        Predicate<Integer> checkIfAdult = age -> age >= 20;
        if (checkIfAdult.test( personAge )) {
            System.out.println("tak ma skonczone 18 lat");
        }
        System.out.println();

        String[] firstNames = {"Maciej", "Bartosz", "Beata", "Monika"};
        String[] lastNames = { "Leszczyńska", "Kaczmarczyk", "Błaszczykowski", "Wydra" };
        int[] ages = {22, 30, 50, 60};
        Random random = new Random();
        Supplier<Person> supplier = () -> {
            String firstName = firstNames[random.nextInt(firstNames.length)];
            String lastName = lastNames[random.nextInt(lastNames.length)];
            int age = ages[random.nextInt(ages.length)];
            return new Person(firstName, lastName, age);
        };
        List<Person> people = new ArrayList<>(  );
        for (int i = 0; i < 5; i++) {
            people.add(supplier.get());

        }
        for (Person person : people) {
            StringBuilder builder = new StringBuilder(  );
            builder.append( person.getName() );
            builder.append( " ");
            builder.append( person.getLastName());
            builder.append( " " );
            builder.append( person.getAge() );
            System.out.println(builder.toString());

        }

    }
}
