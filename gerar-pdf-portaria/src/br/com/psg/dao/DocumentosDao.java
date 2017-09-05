package br.com.psg.dao;

import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import br.com.psg.config.JpaUtil;
import br.com.psg.config.PropertiesConfig;
import br.com.psg.entities.ArquivoDespacho;
import br.com.psg.entities.Credencial;
import br.com.psg.entities.Despachos;
import br.com.psg.entities.PsgPenalidadeDespachos;
import br.com.psg.entities.Retorno;

public class DocumentosDao {

	EntityTransaction tx;
	EntityManager em;

	public DocumentosDao() {
		em = JpaUtil.getEntityManager();
	}

	public Long salvarDocumentos(List<Retorno> docs, Despachos param) {

		tx = em.getTransaction();

		PsgPenalidadeDespachos penalidadeModelo = new PsgPenalidadeDespachos();
		ArquivoDespacho arquivo = new ArquivoDespacho();

		try {
			if (!verificaSeExisteTabelaDespacho(Integer.parseInt(param.getCodEtapa()), param.getNumProcessoBPM(),
					param.getCodCiclo())) {
				tx.begin();

				for (Retorno doc : docs) {
					arquivo.setArquivo(doc.getByteDespacho());
				}

				em.persist(arquivo);

				penalidadeModelo.setArquivo(arquivo);
				penalidadeModelo.setCodEtapa(Integer.parseInt(param.getCodEtapa()));
				penalidadeModelo.setCodProcesso(param.getNumProcessoBPM());
				penalidadeModelo.setTipoRegistro(param.getTipoRegistro());
				penalidadeModelo.setCodProcessoDetran(param.getNumProcesso());
				penalidadeModelo.setCodCiclo(param.getCodCiclo());

				em.persist(penalidadeModelo);

				if (!verificaSeExisteTabelaAssinatura(Integer.parseInt(param.getCodEtapa()),
						Integer.parseInt(param.getNumProcessoBPM()), param.getCodCiclo())) {

					Credencial credencial = new Credencial();
					credencial.setCodEtapa(Integer.parseInt(param.getCodEtapa()));
					credencial.setCodUsuario(1);
					credencial.setCodFormulario(39);
					credencial.setCodProcesso(Integer.parseInt(param.getNumProcessoBPM()));
					credencial.setCodEtapa(Integer.parseInt(param.getCodEtapa()));
					credencial.setNomeModelo("Processo Penalidades");
					credencial.setNomeEtapa(getNomeEtapa(param.getCodEtapa()));
					credencial.setNomeUsuario(getNomeUser(param.getGrupo()));
					credencial.setStatus("Pendente");
					credencial.setDataCadastro(new Date());
					credencial.setDiretorio(penalidadeModelo.getArquivo().getId().toString());
					credencial.setDiretorioAssinado(" ");
					credencial.setNomeAnexo(" ");
					credencial.setTipoRegistro(param.getTipoRegistro());
					credencial.setCodCiclo(param.getCodCiclo());

					em.persist(credencial);
				}
				tx.commit();
				return penalidadeModelo.getArquivo().getId();
			}
			return 0L;

		} catch (Exception e) {
			em.close();
			tx.rollback();
			e.printStackTrace();

		} finally {
			em.close();

		}
		throw new RuntimeException();
	}

	private boolean verificaSeExisteTabelaAssinatura(int etapa, int processo, int codCiclo) {
		// EntityManager em = JpaUtil.getEntityManager();
		try {
			Query q = em.createQuery(
					"from Credencial where codEtapa=:codEtapa and codProcesso=:codProcesso and codCiclo=:codCiclo",
					Credencial.class);

			q.setParameter("codEtapa", etapa);
			q.setParameter("codProcesso", processo);
			q.setParameter("codCiclo", codCiclo);

			List<Credencial> c = q.getResultList();

			if (c.size() > 0) {
				return true;
			}

			return false;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// em.close();
		}
		return false;

	}

	private boolean verificaSeExisteTabelaDespacho(int etapa, String processo, int codCiclo) {
		// EntityManager em = JpaUtil.getEntityManager();
		try {
			Query q = em.createQuery(
					"from PsgPenalidadeDespachos where codEtapa=:codEtapa and codProcesso=:codProcesso and codCiclo=:codCiclo",
					PsgPenalidadeDespachos.class);

			q.setParameter("codEtapa", etapa);
			q.setParameter("codProcesso", processo);
			q.setParameter("codCiclo", codCiclo);

			List<PsgPenalidadeDespachos> c = q.getResultList();

			if (c.size() > 0) {
				return true;
			}

			return false;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// em.close();
		}
		return false;

	}

	private String getNomeUser(String grupo) {
		// EntityManager em = JpaUtil.getEntityManager();
		try {
			Query q = em.createNativeQuery(
					"SELECT NOM_USUARIO FROM USUARIO WHERE COD_USUARIO = (SELECT COD_USUARIO FROM GRUPO G WHERE G.DES_COMANDO =:grupo )");
			q.setParameter("grupo", grupo);
			String nome = (String) q.getSingleResult();
			return nome;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// em.close();
		}
		return null;
	}

	private int getCodCicloAtual(String codProcesso) {
		// EntityManager em = JpaUtil.getEntityManager();
		try {
			Query q = em.createNativeQuery(
					"select  p.COD_CICLO_ATUAL from dbo.PROCESSO p where p.COD_PROCESSO =:codProcesso");
			q.setParameter("codProcesso", codProcesso);
			java.lang.Short codCiclo = (Short) q.getSingleResult();
			return codCiclo;
		} catch (Exception e) {
			em.close();
			e.printStackTrace();
		} finally {
			// em.close();
		}
		return 0;
	}

	private String getNomeEtapa(String codEtapa) {

		Properties prop = new Properties();
		PropertiesConfig config = new PropertiesConfig();
		// EntityManager em = JpaUtil.getEntityManager();
		String nomeEtapa;
		try {
			prop.load(config.getProperties());
			Query q = em
					.createNativeQuery("SELECT DES_ETAPA FROM etapa WHERE COD_FORM =:codForm AND COD_ETAPA =:codEtapa");
			q.setParameter("codForm", prop.getProperty("codFormulario"));
			q.setParameter("codEtapa", codEtapa);
			q.setMaxResults(1);
			
			nomeEtapa = (String) q.getSingleResult();
			
			
			return nomeEtapa;
		} catch (Exception e) {
			//em.close();
			return null;
			
		} finally {
			// em.close();
		}
		//return null;
	}

}
