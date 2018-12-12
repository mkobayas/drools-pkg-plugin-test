package org.mk300.test.pkg;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.kie.api.KieBase;
import org.kie.api.KieServices;
import org.kie.api.io.Resource;
import org.kie.api.io.ResourceType;
import org.kie.api.runtime.KieSession;
import org.kie.internal.utils.KieHelper;
import org.mk300.fact.MyFact;
import org.mk300.util.MyUtil;

public class UsePackageTest {

    static KieBase kbase;
    
    @BeforeClass
    public static void setupKieBase() {
        
        try {
            String pkgFile = "test.pkg";
            
            KieServices kieServices = KieServices.Factory.get();
            
            byte[] pkgBin = Files.readAllBytes(Paths.get("../drools-pkg-plugin-test-build/target", pkgFile));
            Resource pkgResource = kieServices.getResources().newByteArrayResource(pkgBin);
            pkgResource.setResourceType(ResourceType.PKG);
            pkgResource.setSourcePath(pkgFile);
            
            kbase = new KieHelper().addResource(pkgResource).build();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    
    @Test
    public void ruleExec1() throws IOException {
        
        KieSession session = kbase.newKieSession();
        session.setGlobal("myUtil", new MyUtil());
        
        MyFact fact = new MyFact();
        fact.setName("test");
        
        session.insert(fact);
        int fired = session.fireAllRules();
        session.dispose();
        
        Assert.assertEquals(1, fired);
    }
    
    @Test
    public void ruleExec2() throws IOException {
        
        KieSession session = kbase.newKieSession();
        session.setGlobal("myUtil", new MyUtil());
        
        MyFact fact = new MyFact();
        fact.setName("太郎");
        
        session.insert(fact);
        int fired = session.fireAllRules();
        session.dispose();
        
        Assert.assertEquals(1, fired);
    }
}
