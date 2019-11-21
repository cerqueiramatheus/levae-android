package levae.client.core.model.demanda;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import levae.client.core.model.pagamento.Cartao;
import levae.client.core.model.usuarios.Cliente;
import levae.client.core.model.veiculo.TipoVeiculo;
import levae.client.core.model.veiculo.Veiculo;

/**
 * Created by txring on 19/06/2018.
 */
public class Demanda implements Serializable {

    @SerializedName("idDemanda")
    @Expose
    private int idDemanda;

    @SerializedName("estado")
    @Expose
    private String estado;

    @SerializedName("nota")
    @Expose
    private Double nota;

    @SerializedName("distancia")
    @Expose
    private Double distancia;

    @SerializedName("comentario")
    @Expose
    private String comentario;

    @SerializedName("estadoDemanda")
    @Expose
    private String estadoDemanda;

    @SerializedName("estadoPagamento")
    @Expose
    private String estadoPagamento;

    @SerializedName("valorSistema")
    @Expose
    private Double valorSistema;

    @SerializedName("valorCliente")
    @Expose
    private Double valorCliente;

    @SerializedName("valorTransportador")
    @Expose
    private Double valorTransportador;

    @SerializedName("valorTotal")
    @Expose
    private Double valorTotal;

    @SerializedName("dataColeta")
    @Expose
    private String dataColeta;

    @SerializedName("dataLimite")
    @Expose
    private String dataLimite;

    @SerializedName("dataInicio")
    @Expose
    private Timestamp dataInicio;

    @SerializedName("dataSolicitacao")
    @Expose
    private Timestamp dataSolicitacao;

    @SerializedName("dataTransporte")
    @Expose
    private Timestamp dataTransporte;

    @SerializedName("localColeta")
    @Expose
    private String localColeta;

    @SerializedName("localEntrega")
    @Expose
    private String localEntrega;

    @SerializedName("cidadeColeta")
    @Expose
    private String cidadeColeta;

    @SerializedName("cidadeEntrega")
    @Expose
    private String cidadeEntrega;

    @SerializedName("latitudeColeta")
    @Expose
    private Double latitudeColeta;

    @SerializedName("longitudeColeta")
    @Expose
    private Double longitudeColeta;

    @SerializedName("latitudeEntrega")
    @Expose
    private Double latitudeEntrega;

    @SerializedName("longitudeEntrega")
    @Expose
    private Double longitudeEntrega;

    @SerializedName("cliente")
    @Expose
    private Cliente cliente;

    @SerializedName("cartao")
    @Expose
    private Cartao cartao;

    @SerializedName("veiculo")
    @Expose
    private Veiculo veiculo;

    @SerializedName("tituloDemanda")
    @Expose
    private String tituloDemanda;

    @SerializedName("listaObjeto")
    @Expose
    private List<Objeto> listaObjeto;

    @SerializedName("tipoVeiculo")
    @Expose
    private TipoVeiculo tipoVeiculo;

    @SerializedName("nomeDe")
    @Expose
    private String nomeDe;

    @SerializedName("nomePara")
    @Expose
    private String nomePara;

    public Timestamp getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Timestamp dataInicio) {
        this.dataInicio = dataInicio;
    }

    public String getNomeDe() {
        return nomeDe;
    }

    public void setNomeDe(String nomeDe) {
        this.nomeDe = nomeDe;
    }

    public String getNomePara() {
        return nomePara;
    }

    public void setNomePara(String nomePara) {
        this.nomePara = nomePara;
    }

    public String getCidadeColeta() {
        return cidadeColeta;
    }

    public void setCidadeColeta(String cidadeColeta) {
        this.cidadeColeta = cidadeColeta;
    }

    public String getCidadeEntrega() {
        return cidadeEntrega;
    }

    public void setCidadeEntrega(String cidadeEntrega) {
        this.cidadeEntrega = cidadeEntrega;
    }

    public Double getDistancia() {
        return distancia;
    }

    public void setDistancia(Double distancia) {
        this.distancia = distancia;
    }

    public int getIdDemanda() {
        return idDemanda;
    }

    public void setIdDemanda(int idDemanda) {
        this.idDemanda = idDemanda;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Double getNota() {
        return nota;
    }

    public void setNota(Double nota) {
        this.nota = nota;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public String getEstadoDemanda() {
        return estadoDemanda;
    }

    public void setEstadoDemanda(String estadoDemanda) {
        this.estadoDemanda = estadoDemanda;
    }

    public String getEstadoPagamento() {
        return estadoPagamento;
    }

    public void setEstadoPagamento(String estadoPagamento) {
        this.estadoPagamento = estadoPagamento;
    }

    public Double getValorSistema() {
        return valorSistema;
    }

    public void setValorSistema(Double valorSistema) {
        this.valorSistema = valorSistema;
    }

    public Double getValorCliente() {
        return valorCliente;
    }

    public void setValorCliente(Double valorCliente) {
        this.valorCliente = valorCliente;
    }

    public Double getValorTransportador() {
        return valorTransportador;
    }

    public void setValorTransportador(Double valorTransportador) {
        this.valorTransportador = valorTransportador;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public String getDataColeta() {
        return dataColeta;
    }

    public void setDataColeta(String dataColeta) {
        this.dataColeta = dataColeta;
    }

    public String getDataLimite() {
        return dataLimite;
    }

    public void setDataLimite(String dataLimite) {
        this.dataLimite = dataLimite;
    }

    public Timestamp getDataSolicitacao() {
        return dataSolicitacao;
    }

    public void setDataSolicitacao(Timestamp dataSolicitacao) {
        this.dataSolicitacao = dataSolicitacao;
    }

    public Timestamp getDataTransporte() {
        return dataTransporte;
    }

    public void setDataTransporte(Timestamp dataTransporte) {
        this.dataTransporte = dataTransporte;
    }

    public String getLocalColeta() {
        return localColeta;
    }

    public void setLocalColeta(String localColeta) {
        this.localColeta = localColeta;
    }

    public String getLocalEntrega() {
        return localEntrega;
    }

    public void setLocalEntrega(String localEntrega) {
        this.localEntrega = localEntrega;
    }

    public Double getLatitudeColeta() {
        return latitudeColeta;
    }

    public void setLatitudeColeta(Double latitudeColeta) {
        this.latitudeColeta = latitudeColeta;
    }

    public Double getLongitudeColeta() {
        return longitudeColeta;
    }

    public void setLongitudeColeta(Double longitudeColeta) {
        this.longitudeColeta = longitudeColeta;
    }

    public Double getLatitudeEntrega() {
        return latitudeEntrega;
    }

    public void setLatitudeEntrega(Double latitudeEntrega) {
        this.latitudeEntrega = latitudeEntrega;
    }

    public Double getLongitudeEntrega() {
        return longitudeEntrega;
    }

    public void setLongitudeEntrega(Double longitudeEntrega) {
        this.longitudeEntrega = longitudeEntrega;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Cartao getCartao() {
        return cartao;
    }

    public void setCartao(Cartao cartao) {
        this.cartao = cartao;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public List<Objeto> getListaObjeto() {
        return listaObjeto;
    }

    public void setListaObjeto(List<Objeto> listaObjeto) {
        this.listaObjeto = listaObjeto;
    }


    public String getTituloDemanda() {
        return tituloDemanda;
    }

    public void setTituloDemanda(String tituloDemanda) {
        this.tituloDemanda = tituloDemanda;
    }

    public TipoVeiculo getTipoVeiculo() {
        return tipoVeiculo;
    }

    public void setTipoVeiculo(TipoVeiculo tipoVeiculo) {
        this.tipoVeiculo = tipoVeiculo;
    }

    @Override
    public String toString() {
        return "idDemanda=" + idDemanda +
                ", estado='" + estado + '\'' +
                ", nota=" + nota +
                ", distancia=" + distancia +
                ", comentario='" + comentario + '\'' +
                ", estadoDemanda='" + estadoDemanda + '\'' +
                ", estadoPagamento='" + estadoPagamento + '\'' +
                ", valorSistema=" + valorSistema +
                ", valorCliente=" + valorCliente +
                ", valorTransportador=" + valorTransportador +
                ", valorTotal=" + valorTotal +
                ", dataColeta=" + dataColeta +
                ", dataLimite=" + dataLimite +
                ", dataSolicitacao=" + dataSolicitacao +
                ", dataTransporte=" + dataTransporte +
                ", localColeta='" + localColeta + '\'' +
                ", localEntrega='" + localEntrega + '\'' +
                ", latitudeColeta=" + latitudeColeta +
                ", longitudeColeta=" + longitudeColeta +
                ", latitudeEntrega=" + latitudeEntrega +
                ", longitudeEntrega=" + longitudeEntrega +
                ", cliente=" + cliente +
                ", cartao=" + cartao +
                ", veiculo=" + veiculo +
                ", tituloDemanda='" + tituloDemanda + '\'' +
                ", listaObjeto=" + listaObjeto +
                ", tipoVeiculo=" + tipoVeiculo +
                '}';
    }
}