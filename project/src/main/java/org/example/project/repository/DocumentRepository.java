package org.example.project.repository;


import org.example.project.model.Document;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface DocumentRepository extends JpaRepository<Document, Long> {

    @Query(value = "SELECT  trpz.add_document(?1, ?2, ?3, ?4, ?5)", nativeQuery = true)
    String addDocument(int siteId, String url, String parentUrl, String status, int level);

    @Query(value = "SELECT * FROM trpz.get_all_documents()", nativeQuery = true)
    List<Document> getAllDocs();

    @Query(value = "SELECT trpz.save_content(?1, ?2, ?3, ?4, ?5)", nativeQuery = true)
    void saveContent(int docId, String title, String content, String status, int httpStatus);


}
