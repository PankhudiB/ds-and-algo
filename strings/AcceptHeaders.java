package strings;

import java.util.*;

public class AcceptHeaders {
    public static void main(String[] args) {
        AcceptHeaders a = new AcceptHeaders();
        System.out.println(a.parse_accept_language("en-US, fr-CA, fr-FR", new String[]{"fr-FR", "en-US"}));
        System.out.println(a.parse_accept_language("fr-CA, fr-FR", new String[]{"en-US", "fr-FR"}));
    }

    public List<String> parse_accept_language(String clientHeader, String[] serverSupported) {
        Set<String> serverSupportedHeaders = new HashSet<>(Arrays.asList(serverSupported));
        List<String> result = new ArrayList<>();

        Arrays.stream(clientHeader.split(",")).map(String::trim).filter(serverSupportedHeaders::contains).forEach(result::add);
        return result;
    }
}
