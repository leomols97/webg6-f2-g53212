package webg66.commitManager.business;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import webg66.commitManager.repository.CommitEDB;
import webg66.commitManager.repository.RepositoryDB;
import webg66.commitManager.dtos.RepositoryDetailDto;
import webg66.commitManager.dtos.RepositoryDto;
import webg66.commitManager.entities.CommitE;
import webg66.commitManager.entities.Repository;

@Service
public class MyService {
    
    @Autowired
    private RepositoryDB repositoryDB;

    @Autowired
    private CommitEDB commitEDB;

    public List<RepositoryDto> getRepositories(){
        List<RepositoryDto> dtos = new ArrayList<RepositoryDto>();
        for (Object[] repository : repositoryDB.getRepositories()) {
            RepositoryDto dto = new RepositoryDto(repository[0], repository[1], repository[2], repository[3]);
            dtos.add(dto);
        }
        return dtos;
    }

    public RepositoryDetailDto getRepositoryDetail(int repositoryId){
        List<Object[]> results = repositoryDB.getRepositoryDetail(repositoryId);

        List<String> commits = new ArrayList<>();
        for (Object[] tuple : results) {
            commits.add(tuple[3].toString()+"<br/>");
        }

        RepositoryDetailDto dto = new RepositoryDetailDto(results.get(0)[0], results.get(0)[1], results.get(0)[2], commits);
        return dto; 
    }

    public void addCommitToRepository(int repoId, CommitE commit){
        
        commit.setDate(LocalDate.now());
        commit.setRepository(repositoryDB.findById(repoId).get());
        commitEDB.save(commit);
        
    }
    
}
