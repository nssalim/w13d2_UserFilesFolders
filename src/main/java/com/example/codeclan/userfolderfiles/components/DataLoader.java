package com.example.codeclan.userfolderfiles.components;
import com.codeclan.example.userfolderfiles.models.File;
import com.codeclan.example.userfolderfiles.models.Folder;
import com.codeclan.example.userfolderfiles.models.User;
import com.codeclan.example.userfolderfiles.repository.FileRepository;
import com.codeclan.example.userfolderfiles.repository.FolderRepository;
import com.codeclan.example.userfolderfiles.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    FileRepository fileRepository;

    @Autowired
    FolderRepository folderRepository;

    @Autowired
    UserRepository userRepository;

    public DataLoader() {
    }

    public void run(ApplicationArguments args){
        User RhettButler = new User("RhettButler");
        userRepository.save(RhettButler);

        User ScarlettOHara = new User("Scarlett O Hara");
        userRepository.save(ScarlettOHara);

        User OliviaDeHaviland = new User("Olivia De Haviland");
        userRepository.save(OliviaDeHaviland);

        Folder Actors = new Folder("Actors", RhettButler);
        folderRepository.save(Actors);

        Folder Directors = new Folder("Directors", ScarlettOHara);
        folderRepository.save(Directors);

        Folder Editors = new Folder("Editors", OliviaDeHaviland);
        folderRepository.save(Editors);

        File GoneWithTheWind = new File("Gone With the Wind", ".pdf", 25000, RhettButler);
        fileRepository.save(GoneWithTheWind);

        File HattieMcDaniel = new File("Hattie McDaniel", ".doc", 700, Actors);
        fileRepository.save(HattieMcDaniel);

        Actors.addFile(HattieMcDaniel);
        Actors.addFile(GoneWithTheWind);
        folderRepository.save(Actors);
        
    }

}


