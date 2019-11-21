package levae.client.view.cadastro.cadastroDadosPessoais;

import levae.client.core.util.CPFValidator;
import levae.client.core.util.Constantes;

/**
 * Created by txring on 23/04/2019.
 */
public class CadastroDadosPessoaisPresenter implements CadastroDadosPessoaisInterface.Presenter {

    private CadastroDadosPessoaisInterface.View mView;

    CadastroDadosPessoaisPresenter(CadastroDadosPessoaisInterface.View view) {
        view.setPresenter(this);
        mView = view;
    }

    @Override
    public void verificaDadosPessoais(String nome, String celular, String nascimento, String cpf) {
        if (nome.equals("")) {
            mView.onNomeErro(Constantes.ERRO_NOME);
        } else if (celular.equals("")) {
            mView.onCelularErro(Constantes.ERRO_CELULAR);
        } else if (nascimento.equals("")) {
            mView.onNascimentoErro(Constantes.ERRO_NASCIMENTO);
        } else if (cpf.equals("") || !CPFValidator.isCPF(cpf)) {
            mView.onCPFErro("CPF inválido");
        } else {
            mView.onContinuar(nome, celular, nascimento, cpf);
        }
    }
}