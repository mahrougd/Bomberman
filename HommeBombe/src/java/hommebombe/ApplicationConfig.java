package hommebombe;

import java.util.Set;
import javax.ws.rs.core.Application;


@javax.ws.rs.ApplicationPath("webresources")
public class ApplicationConfig extends Application {

    int a = 5;
    
    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }
    
    public int geta(){
        return (int) Math.random() * 5;
    }

    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(hommebombe.Moves.class);
        resources.add(hommebombe.Test.class);
    }
    
}
