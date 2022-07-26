package davila.lucas.uno.morintegracaocomjava.database_app.interfaces_dao;

import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;
import androidx.room.OnConflictStrategy;
import androidx.room.Update;

import java.util.List;

import davila.lucas.uno.morintegracaocomjava.database_app.tabelas.Aluno;
import davila.lucas.uno.morintegracaocomjava.database_app.tabelas.Pergunta;


public interface ICRUDPerguntaDAO {

    @Transaction
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertPergunta(Pergunta tbl_pergunta);

    //public void insertPergunta (Pergunta tbl_pergunta);

    @Query("SELECT * FROM tbl_pergunta where id = :id")
    Pergunta getEspecificaPerguntaById(int id);

    //public String getEspecificPerguntasByID(Pergunta id);

   List<Pergunta> getAllPerguntas();

   //void updatePerguntas (Pergunta tbl_pergunta);

   //void deletePergunta(Pergunta tbl_pergunta);

   //void deletePerguntasByID(Pergunta id);

   //void deleteAllPerguntas ();

    @Transaction
    @Update(entity = Pergunta.class, onConflict = OnConflictStrategy.REPLACE)
    void updatePerguntas(Pergunta perguntaTable);

    //O CASCADE deverá funcionar aqui p/ a tabela: AlunoProva
    @Transaction
    @Delete(entity = Pergunta.class)
    void deletePergunta(Pergunta perguntaTable);

    @Transaction
    @Query("DELETE FROM tbl_pergunta WHERE id = :id")
    void deleteperguntaByID(int id);

    @Transaction
    @Query("DELETE FROM tbl_pergunta WHERE id > 0")
    void deleteAllPerguntas();
}
