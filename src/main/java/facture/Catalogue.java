package facture;

import java.util.HashMap;

public class Catalogue {
    HashMap<String, Article> cat = new HashMap();

    public void addArticle(Article article) {
        cat.put(article.getCode(), article);
    }
    
    public Article findByCode(String code) {
        Article a = null;
        for (int i=0; i < cat.size(); i++){
            if(cat.containsKey(code)){
                a = cat.get(code);
            }
        }
        return a;
    }
    
}
