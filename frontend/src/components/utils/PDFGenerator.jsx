import { jsPDF } from "jspdf";
import Api from '../../services/Api';


export default function PDFGenerator(ordenData, idOrden, endpoints, errorGenerator) {

    let services

    const constructPDF = () => {
        Api.listServicesQuery(endpoints.listServices, { idOrden: idOrden })
            .then((response) => {
                services = response.data
                generatePDF(services)
            })
            .catch((error) => {
                errorGenerator.setError(
                    {
                        state: true, message: `Error al intentar generar el PDF de la factura\n
            ${error.message}`
                    }
                )
            })
    }

    const generatePDF = (services) => {
        if (services.length > 0) {
            const doc = new jsPDF();
            let img = new Image()
            let date = new Date().toLocaleDateString('es')
            img.src = 'images/logo.png'
            let y = 5,
                x = 15,
                totalLiquido = 0
            doc.addImage(img, 'png', x - 5, y, 30, 20)
            y += 35
            doc.setFontSize(20);
            doc.text("Factura de servicios", x, y);
            doc.setFontSize(11);
            y += 10
            doc.text("N.º orden: ", x, y);
            doc.text(ordenData.id.toString(), x + 20, y);
            y += 5
            doc.text(date, x, y);
            // ================================================
            y += 10
            doc.setFontSize(12);
            doc.text("Cliente", x, y);
            doc.setFontSize(9);
            y += 10
            doc.text(ordenData.cliente.descripcion, x, y);
            y += 5
            doc.text(ordenData.cliente.direccion, x, y);
            y += 5
            doc.text(ordenData.cliente.localidad, x, y);
            // ================================================
            // ================================================
            y -= 20
            doc.setFontSize(12);
            doc.text("Vehiculo", x + 75, y);
            doc.setFontSize(9);
            y += 10
            doc.text(ordenData.vehiculo.descripcion, x + 75, y);
            y += 5
            doc.text(ordenData.vehiculo.modelo.marca.nombre, x + 75, y);
            y += 5
            doc.text(ordenData.vehiculo.modelo.nombre, x + 75, y);
            // ================================================
            // ================================================ 
            y -= 20
            doc.setFontSize(12);
            doc.text("Prestador", x + 150, y);
            doc.setFontSize(9);
            y += 10
            doc.text(ordenData.tecnico.descripcion, x + 150, y);
            y += 5
            doc.text("Hipolito Yrigoyen 345", x + 150, y);
            y += 5
            doc.text("Villa Maria, Cba.", x + 150, y);
            y += 5
            doc.text("20-12345678-1", x + 150, y);
            // ================================================
            doc.setFontSize(14);
            y += 20
            doc.text("Servicio", x, y);
            doc.text("Precio", x + 135, y);
            y += 5
            doc.line(x , y, x + 180, y, "S")
            doc.setFontSize(12);
            y += 15
            services.map((value, index) => {
                doc.text(value.tipoServicio, x, y);
                doc.text("$ " + value.precio.toLocaleString(), x + 135, y);
                y += 10
                totalLiquido += value.precio
            })
            let totalPorcentaje = totalLiquido * ordenData.vehiculo.modelo.marca.impuesto.porcentaje / 100,
            totalFinal = totalLiquido + totalPorcentaje

            y += 5
            doc.line(x + 80, y, x + 180, y, "S")
            y += 15
            doc.setFontSize(12);
            doc.text("TOTAL LIQUIDO", x + 80, y);
            doc.text("$ " + totalLiquido.toLocaleString(), x + 135, y);
            doc.setFontSize(12);
            y += 8
            doc.text(`${ordenData.vehiculo.modelo.marca.impuesto.nombre} ( ${ordenData.vehiculo.modelo.marca.impuesto.porcentaje.toString()}% )`, x + 80, y);
            doc.text("$ " + totalPorcentaje.toLocaleString(), x + 135, y);
            doc.setFontSize(14);
            y += 8
            doc.text("TOTAL", x + 80, y);
            doc.text("$ " + totalFinal.toLocaleString(), x + 135, y);
            y += 30
            doc.line(x + 115, y, x + 180, y, "S")
            doc.setFontSize(12);
            y += 6
            doc.text("Firma prestador", x + 135, y);

            doc.output('dataurlnewwindow');
        }
    }

    constructPDF()

}