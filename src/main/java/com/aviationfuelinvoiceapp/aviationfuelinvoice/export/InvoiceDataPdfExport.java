package com.aviationfuelinvoiceapp.aviationfuelinvoice.export;

import com.aviationfuelinvoiceapp.aviationfuelinvoice.entity.Invoice;
import com.lowagie.text.*;
import com.lowagie.text.Font;
import com.lowagie.text.Image;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.util.Date;
import java.util.Map;

public class InvoiceDataPdfExport extends AbstractPdfView {

    @Override
    protected void buildPdfMetadata(Map<String, Object> model, Document document, HttpServletRequest request)
    {

        // set header - optional

//        Font headerFont = new Font(Font.TIMES_ROMAN, 15, Font.BOLD, Color.black);
//        HeaderFooter header = new HeaderFooter(new Phrase("Invoice PDF view", headerFont), false);
//        header.setAlignment(Element.ALIGN_LEFT);
//        document.setHeader(header);

        // set footer - optional

//        Font dateFont = new Font(Font.HELVETICA, 12, Font.NORMAL, Color.BLUE);
//
//        HeaderFooter footer = new HeaderFooter(new Phrase("PDF Export Executed On : "+new Date(), dateFont), true);
//        footer.setAlignment(Element.ALIGN_CENTER);
//        document.setFooter(footer);
    }

    @Override
    protected void buildPdfDocument(
            Map<String, Object> model,
            Document document,
            PdfWriter writer,
            HttpServletRequest request,
            HttpServletResponse response)
            throws Exception
    {

        //download PDF with a given filename
        // response.addHeader("Content-Disposition", "attachment;filename=Invoices.pdf");

        //open PDF in new tab
        response.addHeader("Content-Disposition", "inline;filename=Invoices.pdf");

        // read data from controller
        // List<Invoice> list = (List<Invoice>) model.get("list");
        Invoice theInvoice = (Invoice) model.get("invoice");

        //create element
        Font titleFont = new Font(Font.TIMES_ROMAN, 16, Font.BOLD, Color.black);
        Font infoFont = new Font(Font.TIMES_ROMAN, 12, Font.NORMAL, Color.black);
        Paragraph space = new Paragraph(" ",titleFont);
        Paragraph info1 = new Paragraph(theInvoice.getAirline().getName(), titleFont);
        Paragraph info2 = new Paragraph(theInvoice.getAirline().getAddress(), infoFont);
        Paragraph info3 = new Paragraph(theInvoice.getAirline().getEmail(), infoFont);

        //right side
        Paragraph invNumber = new Paragraph("INVOICE# " + theInvoice.getId(), titleFont);

        info1.setAlignment(Element.ALIGN_LEFT);
        info1.setSpacingBefore(100.0f);
        info2.setAlignment(Element.ALIGN_LEFT);
        info3.setAlignment(Element.ALIGN_LEFT);
        invNumber.setAlignment(Element.ALIGN_RIGHT);

        invNumber.setSpacingAfter(40.0f);

        //add to document
        document.add(space);
        document.add(info1);
        document.add(info2);
        document.add(info3);
        document.add(invNumber);

        Font tableHead = new Font(Font.TIMES_ROMAN, 12, Font.BOLD, Color.black);
        PdfPTable table = new PdfPTable(4);// no.of columns

        table.addCell(new Phrase("Product",tableHead));
        table.addCell(new Phrase("Quantity",tableHead));
        table.addCell(new Phrase("Unit price",tableHead));
        table.addCell(new Phrase("Total price",tableHead));


        table.addCell("JET A1 - Aviation fuel");
        table.addCell(theInvoice.getUpliftKg().toString());
        table.addCell(theInvoice.getPrice().toString());
        table.addCell(theInvoice.getTotalPrice().toString());

        table.setSpacingBefore(20.0f);
        table.setSpacingAfter(20.0f);

        //add table data to document
        document.add(table);

        // sub total/ total display on right side
        Font subTotalFont = new Font(Font.TIMES_ROMAN, 12, Font.NORMAL, Color.black);
        Font totalFont = new Font(Font.TIMES_ROMAN, 12, Font.BOLD, Color.black);
        Paragraph subTotal = new Paragraph("Sub total: " + theInvoice.getTotalPrice().toString(), subTotalFont);
        Paragraph tax = new Paragraph("Tax: N/A", subTotalFont);
        Paragraph total = new Paragraph("Total: " + theInvoice.getTotalPrice(), totalFont);

        // invoice / uplift info display on left side
        Paragraph ticketNumber = new Paragraph("Ticket number: " + theInvoice.getTicketNumber().toString(), subTotalFont);
        Paragraph flightNumber = new Paragraph("Flight number: " + theInvoice.getFlightNumber().toString(), subTotalFont);
        Paragraph aircraftReg = new Paragraph("Aircraft registration number: " + theInvoice.getAircraftRegistration().toString(), subTotalFont);
        Paragraph aircraftType = new Paragraph("Aircraft type " + theInvoice.getAircraftType().toString(), subTotalFont);
        Paragraph authNote = new Paragraph("Authorization note: " + theInvoice.getAuthorizationNote().toString(), subTotalFont);

        ticketNumber.setAlignment(Element.ALIGN_LEFT);
        flightNumber.setAlignment(Element.ALIGN_LEFT);
        aircraftReg.setAlignment(Element.ALIGN_LEFT);
        aircraftType.setAlignment(Element.ALIGN_LEFT);
        authNote.setAlignment(Element.ALIGN_LEFT);

        subTotal.setAlignment(Element.ALIGN_RIGHT);
        tax.setAlignment(Element.ALIGN_RIGHT);
        total.setSpacingBefore(10.0f);
        total.setAlignment(Element.ALIGN_RIGHT);
        total.setSpacingAfter(60.0f);

        document.add(subTotal);
        document.add(tax);
        document.add(total);

        document.add(ticketNumber);
        document.add(flightNumber);
        document.add(aircraftReg);
        document.add(aircraftType);
        document.add(authNote);



//        Image imghead = Image.getInstance("WebContent/images/letterHead.jpg");
//        imghead.setAbsolutePosition(35,770);
//        imghead.scaleAbsolute(125, 42);
//        document.add(imghead);

        Image image = Image.getInstance("C:\\Users\\HP\\Desktop\\imgs\\letter.png");
        float width = document.getPageSize().getWidth();
        float height = document.getPageSize().getHeight();
        image.scaleAbsolute(width, height);
        image.setAbsolutePosition(0,0);

        document.add(image);

    }
}
