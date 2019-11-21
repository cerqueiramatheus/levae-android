package levae.client.view.cadastro.cadastroDadosPessoais;

import levae.client.core.base.BaseView;

/**
 * Created by txring on 01/05/2019.
 */
public interface CadastroDadosPessoaisInterface {

    interface View extends BaseView<Presenter> {

        void onContinuar(String nome, String celular, String nascimento, String cpf);

        void onNomeErro(String msg);

        void onCelularErro(String msg);

        void onNascimentoErro(String msg);

        void onCPFErro(String msg);
    }

    interface Presenter {
        void verificaDadosPessoais(String nome, String celular, String nascimento, String cpf);
    }
}
