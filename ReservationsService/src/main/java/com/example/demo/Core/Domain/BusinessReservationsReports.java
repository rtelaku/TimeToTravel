package com.example.demo.Core.Domain;

import com.example.demo.Application.InputPort.ReservationInputPort;
import com.example.demo.Core.OutputPort.BusinessOutputPort;
import com.lowagie.text.Font;
import com.lowagie.text.*;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.io.IOException;
import java.util.List;

public class BusinessReservationsReports {

    @Autowired
    private ReservationInputPort reservationInputPort;

    @Autowired
    private BusinessOutputPort businessOutputPort;

    public BusinessReservationsReports(ReservationInputPort reservationInputPort, BusinessOutputPort businessOutputPort) {
        this.reservationInputPort = reservationInputPort;
        this.businessOutputPort = businessOutputPort;
    }

    private void writeTableHeader(PdfPTable table) {
            PdfPCell cell = new PdfPCell();
            cell.setBackgroundColor(Color.white);
            cell.setPadding(5);

            Font headerFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
            headerFont.setSize(18);
            headerFont.setColor(Color.DARK_GRAY);

            cell.setPhrase(new Phrase("Room Type", headerFont));
            table.addCell(cell);

            cell.setPhrase(new Phrase("Booked Rooms", headerFont));
            table.addCell(cell);

            cell.setPhrase(new Phrase("Price", headerFont));
            table.addCell(cell);
        }
    private void writeTableData(String businessUsername,PdfPTable table) {
        List<String> roomTypes = this.reservationInputPort.getReservedRoomTypes(businessUsername);
        double totalAmount=0;
        int allBookedRooms=0;
        for(int i=0;i<roomTypes.size()+1;i++){
            if(i<roomTypes.size()) {
            int bookedRooms = this.reservationInputPort.getRoomReservationNumberByRoomType(roomTypes.get(i),businessUsername);
            double amount = this.reservationInputPort.getAmountOfRoomsByType(roomTypes.get(i),businessUsername);
            totalAmount+=amount;
            allBookedRooms += bookedRooms;
                table.addCell(roomTypes.get(i));
                table.addCell(String.valueOf(bookedRooms));
                table.addCell(amount + "€");
            } else {
                table.addCell("Total");
                table.addCell(String.valueOf(allBookedRooms));
                table.addCell(totalAmount + "€");
            }
        }
    }

    public void export(String businessUsername,HttpServletResponse httpServletResponse) throws IOException {

        Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document, httpServletResponse.getOutputStream());

        document.open();

        Font textFont = FontFactory.getFont(FontFactory.HELVETICA);
        textFont.setSize(14);
        textFont.setColor(Color.DARK_GRAY);

        Font headerFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        headerFont.setSize(18);
        headerFont.setColor(Color.darkGray);

        Paragraph p = new Paragraph("Reservations Stats", headerFont);
        p.setAlignment(Paragraph.ALIGN_CENTER);
        document.add(p);

        PdfPTable table = new PdfPTable(3);
        table.setWidthPercentage(100f);
        table.setWidths(new float[] {3.0f, 3.0f, 3.0f});
        table.setSpacingBefore(10);
        table.getDefaultCell().setBackgroundColor(Color.ORANGE);

        writeTableHeader(table);
        writeTableData(businessUsername,table);

        document.add(table);
        document.close();
    }
}
