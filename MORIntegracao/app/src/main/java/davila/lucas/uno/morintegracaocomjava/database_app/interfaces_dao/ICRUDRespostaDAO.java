package davila.lucas.uno.morintegracaocomjava.database_app.interfaces_dao;

import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Transaction;
import androidx.room.Update;

import java.util.List;

import davila.lucas.uno.morintegracaocomjava.database_app.tabelas.Aluno;
import davila.lucas.uno.morintegracaocomjava.database_app.tabelas.Resposta;


public interface ICRUDRespostaDAO {

   @Transaction
   @Insert(onConflict = OnConflictStrategy.REPLACE)
   void insertResposta(Resposta tbl_resposta);

    //public void insertResposta (Resposta tbl_resposta);

   @Query("SELECT * FROM tbl_resposta where id = :id")
   Resposta getEspecificaRespostaById(int id);

    //public String getEspecificRespostasByID(Resposta id);

   List<Resposta> getAllRespostas();

   //void updateRespostas (Resposta tbl_resposta);

   //void deleteResposta(Resposta tbl_resposta);

   //void deleteRespostaByID(Resposta id);

   //void deleteAllRespostas ();

   @Transaction
   @Update(entity = Resposta.class, onConflict = OnConflictStrategy.REPLACE)
   void updateRespostas(Resposta respostaTable);

   //O CASCADE deverá funcionar aqui p/ a tabela: AlunoProva
   @Transaction
   @Delete(entity = Resposta.class)
   void deleteResposta(Resposta respostaTable);

   @Transaction
   @Query("DELETE FROM tbl_resposta WHERE id = :id")
   void deleteRespostaByID(int id);

   @Transaction
   @Query("DELETE FROM tbl_resposta WHERE id > 0")
   void deleteAllRespostas();
}
