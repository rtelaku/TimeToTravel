package com.example.demo.Core.Domain;

import java.awt.Color;
import java.io.IOException;
import javax.servlet.http.HttpServletResponse;
import com.example.demo.Core.Entities.Reservation;
import com.lowagie.text.*;
import com.lowagie.text.pdf.*;

public class ReservationInvoice {

    private final Reservation reservation;

    public ReservationInvoice(Reservation reservation) {
        this.reservation=reservation;
    }

    public void export(HttpServletResponse response) throws DocumentException, IOException {
        Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document, response.getOutputStream());

        document.open();
        //invoice title
        Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        font.setSize(18);
        font.setColor(Color.RED);
        Paragraph p = new Paragraph(reservation.getBusiness().getBusinessName(), font);
        p.setAlignment(Paragraph.ALIGN_CENTER);
        document.add(p);
        System.out.println("\n");
        System.out.println("\n");
        System.out.println("\n");
        // invoice body
        Font bodyFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        bodyFont.setSize(12);
        bodyFont.setColor(Color.BLACK);
        Paragraph p1 = new Paragraph(reservation.getBusiness().getBusinessPhoneNumber() + "\n" + reservation.getBusiness().getBusinessEmail(), bodyFont);
        p1.setAlignment(Paragraph.ALIGN_LEFT);
        System.out.println("\n");

        Font bookingtitle = FontFactory.getFont(FontFactory.HELVETICA);
        bookingtitle.setSize(18);
        bookingtitle.setColor(Color.black);

        Paragraph p2 = new Paragraph("\n"+"Booking Details", bookingtitle);
        p2.setAlignment(Paragraph.ALIGN_LEFT);
        System.out.println("\n");
        System.out.println("\n");
        System.out.println("\n");
        Paragraph p3 = new Paragraph("Accommodation: "+"\t"+reservation.getRoom().getRoomType() + "\t" + " Number: " +reservation.getRoom().getRoomNumber(), bodyFont);
        p3.setAlignment(Paragraph.ALIGN_LEFT);
        System.out.println("\n");
        Paragraph p4 = new Paragraph("Check in: "+"\t"+reservation.getCheckInDate(), bodyFont);
        p4.setAlignment(Paragraph.ALIGN_LEFT);
        System.out.println("\n");
        Paragraph p5 = new Paragraph("Check out: "+"\t"+reservation.getCheckOutDate(), bodyFont);
        p5.setAlignment(Paragraph.ALIGN_LEFT);
        System.out.println("\n");
        System.out.println("\n");
        System.out.println("\n");
        Paragraph p6 = new Paragraph("GUEST", bodyFont);
        p6.setAlignment(Paragraph.ALIGN_CENTER);
        System.out.println("\n");
        Paragraph p7 = new Paragraph(reservation.getTourist().getTouristName(), bodyFont);
        p7.setAlignment(Paragraph.ALIGN_LEFT);
        System.out.println("\n");
        Paragraph p14 = new Paragraph("Username: "+"  "+reservation.getTourist().getTouristUsername(), bodyFont);
        p14.setAlignment(Paragraph.ALIGN_LEFT);
        System.out.println("\n");
        Paragraph p8 = new Paragraph("Email: "+"  "+reservation.getTourist().getTouristEmail(), bodyFont);
        p8.setAlignment(Paragraph.ALIGN_LEFT);

        System.out.println("\n");
        System.out.println("\n");
        System.out.println("\n");

        Paragraph p9 = new Paragraph("\n"+"Invoice", bookingtitle);
        p9.setAlignment(Paragraph.ALIGN_LEFT);
        System.out.println("\n");
        System.out.println("\n");
        System.out.println("\n");

        Paragraph p10 = new Paragraph("Date: "+"\t"+reservation.getReservationDate() + "\t" + "  |  " +reservation.getReservationTime(), bodyFont);
        p10.setAlignment(Paragraph.ALIGN_LEFT);
        System.out.println("\n");
        Paragraph p11 = new Paragraph("Price: "+"\t"+reservation.getRoom().getRoomPrice()+"€", bodyFont);
        p11.setAlignment(Paragraph.ALIGN_LEFT);
        System.out.println("\n");
        Paragraph p12 = new Paragraph("Discount: "+"\t"+reservation.getRoom().getRoomDiscount()+"%", bodyFont);
        p12.setAlignment(Paragraph.ALIGN_LEFT);
        System.out.println("\n");
        Paragraph p13 = new Paragraph("Total Price: "+"\t"+reservation.getTotalPrice()+"€", bodyFont);
        p13.setAlignment(Paragraph.ALIGN_LEFT);

        document.add(p1);
        document.add(p2);
        document.add(p3);
        document.add(p4);
        document.add(p5);
        document.add(p6);
        document.add(p7);
        document.add(p14);
        document.add(p8);
        document.add(p9);
        document.add(p10);
        document.add(p11);
        document.add(p12);
        document.add(p13);

        document.close();
    }
}
