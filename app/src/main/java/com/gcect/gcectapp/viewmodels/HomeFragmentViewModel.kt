package com.gcect.gcectapp.viewmodels


import androidx.lifecycle.ViewModel
import com.gcect.gcectapp.model.GateRankerDetails
import com.gcect.gcectapp.model.PdfInfo
import com.gcect.gcectapp.utils.Constants

class HomeFragmentViewModel: ViewModel() {
    private val _noticeItemList = ArrayList<PdfInfo>()
    val noticeItemList:List<PdfInfo> = _noticeItemList

    private val _redNoticeItemList = ArrayList<PdfInfo>()
    val redNoticeItemList:List<PdfInfo> = _redNoticeItemList

    private val _bottomSheetItemList = ArrayList<PdfInfo>()
    val bottomSheetItemList:List<PdfInfo> = _bottomSheetItemList

    private val _autoSliderImgList = ArrayList<String>()
    val autoSliderImgList:List<String> = _autoSliderImgList

    private val _gateRankerList = ArrayList<GateRankerDetails>()
    val gateRankerList:List<GateRankerDetails> = _gateRankerList

    val graduateDayVideoUrl = "https://www.youtube.com/watch?v=CnDo3MDO6jM&t=456s"
    init {
        addNoticeItemToList()
        addBottomSheetItemToList()
        addRedNoticeItemToList()
        addAutoSliderImagesToList()
        addGateRankerDetailsToList()
    }

    private fun addNoticeItemToList(){
        _noticeItemList.add(PdfInfo("IMAGE EDITING WITH PHOTOSHOP COURSE OFFERED BY DEPT. OF IT, GCECT (COURSE DETAIL)"
            ,"https://firebasestorage.googleapis.com/v0/b/gcect-app.appspot.com/o/home%20page%20upper%20notices%2Fcourse_detail.pdf?alt=media&token=8194569d-1a5f-4736-af74-95c4f292b447"))
        _noticeItemList.add(PdfInfo("IMAGE EDITING WITH PHOTOSHOP COURSE OFFERED BY DEPT. OF IT, GCECT (APPLICATION fORM)"
            ,"https://firebasestorage.googleapis.com/v0/b/gcect-app.appspot.com/o/home%20page%20upper%20notices%2FCourse_Applicatn_form.pdf?alt=media&token=80608bec-d0da-4616-9c21-81a1d22a51b3"))
    }

    private fun addBottomSheetItemToList(){
        _bottomSheetItemList.add(PdfInfo("Hybrid Routine for CT 3rd, 5th & 7th Semester, 2021"
            ,"https://firebasestorage.googleapis.com/v0/b/gcect-app.appspot.com/o/home%20page%20general%20notices%2Fpdf1.pdf?alt=media&token=12e220ac-6411-4f90-b9e1-6b6ab148e2ee"))
        _bottomSheetItemList.add(PdfInfo("Online Routine for IT 3rd, 5th & 7th Semester, 2021"
            ,"https://firebasestorage.googleapis.com/v0/b/gcect-app.appspot.com/o/home%20page%20general%20notices%2Fpdf2.pdf?alt=media&token=56871641-51e7-4a4a-b9aa-e886a8147de2"))
        _bottomSheetItemList.add(PdfInfo("Hybrid Routine for CT, IT & CSE Ist Semester, 2021"
            ,"https://firebasestorage.googleapis.com/v0/b/gcect-app.appspot.com/o/home%20page%20general%20notices%2Fpdf3.pdf?alt=media&token=58201876-e918-4793-a5af-a6a70a2c852e"))
        _bottomSheetItemList.add(PdfInfo("Hybrid Routine for CSE 3rd, 5th & 7th Semester, 2021"
            ,"https://firebasestorage.googleapis.com/v0/b/gcect-app.appspot.com/o/home%20page%20general%20notices%2Fpdf4.pdf?alt=media&token=a958d9d6-a73f-46ea-a0a6-14103b8ed465"))
        _bottomSheetItemList.add(PdfInfo("Advertisement for the post of JRF/Project Associate-I in SERB-DST Sponsored Project"
            ,"https://firebasestorage.googleapis.com/v0/b/gcect-app.appspot.com/o/home%20page%20general%20notices%2Fpdf5.pdf?alt=media&token=54b0082d-9892-43a0-8d9c-0e3cc40d09e3"))
        _bottomSheetItemList.add(PdfInfo("College Opening Notice"
            ,"https://firebasestorage.googleapis.com/v0/b/gcect-app.appspot.com/o/home%20page%20general%20notices%2Fpdf6.pdf?alt=media&token=313797ba-f37e-46a3-aa16-9bcbbbfa59a0"))
        _bottomSheetItemList.add(PdfInfo("4th Graduate Day Notice(Modified)"
            ,"https://firebasestorage.googleapis.com/v0/b/gcect-app.appspot.com/o/home%20page%20general%20notices%2Fpdf7.pdf?alt=media&token=e9f394c4-6d06-4739-bddb-490574aa28b7"))
        _bottomSheetItemList.add(PdfInfo("Advertisement for the post of JRF in SERB-DST Sponsored Project"
            ,"https://firebasestorage.googleapis.com/v0/b/gcect-app.appspot.com/o/home%20page%20general%20notices%2Fpdf8.pdf?alt=media&token=134a6e77-eba0-4013-9feb-bd4ca9e59286"))
        _bottomSheetItemList.add(PdfInfo("Advertisement for the post of SRF in IREL (India) Limited Sponsored Project"
            ,"https://firebasestorage.googleapis.com/v0/b/gcect-app.appspot.com/o/home%20page%20general%20notices%2Fpdf9.pdf?alt=media&token=4bcab6e9-c19c-4aff-8010-072ee822d97b"))
    }

    private fun addRedNoticeItemToList(){
        _redNoticeItemList.add(
            PdfInfo("ONLINE EXAMINATION SCHEDULE FOR SEMESTER END EXAMINATION"
                , "https://firebasestorage.googleapis.com/v0/b/gcect-app.appspot.com/o/home%20page%20red%20coloured%20important%20notices%2Fpdf1.pdf?alt=media&token=21809f1e-91ee-4532-944e-ef98935c501a"
        ))

        _redNoticeItemList.add(
            PdfInfo("STUDENT FREE-SHIP APPLICATION FORM"
                , "https://firebasestorage.googleapis.com/v0/b/gcect-app.appspot.com/o/home%20page%20red%20coloured%20important%20notices%2FStudent-FREESHIP-2021-22.pdf%20(pdf2).pdf?alt=media&token=b0f1059f-eb48-4483-b143-1aca0d18a7ed"
            ))

        _redNoticeItemList.add(
            PdfInfo("MENTOR – STUDENT RELATIONTIONSHIP CHART FOR 1ST YEAR STUDENTS (2021-22 BATCH)"
                , "https://firebasestorage.googleapis.com/v0/b/gcect-app.appspot.com/o/home%20page%20red%20coloured%20important%20notices%2Fmentor-student-relationship-1st-yr-2021-2022-batch.pdf%20(pdf3).pdf?alt=media&token=c0e315e2-48c4-48a2-9547-5297c9f15bee"
            ))

        // for youtube video, not for pdf
        _redNoticeItemList.add(
            PdfInfo("FOURTH GRADUATE DAY – NOVEMBER 07, 2021 FULL VIDEO"
                , ""
            ))
    }

    private fun addAutoSliderImagesToList(){
        _autoSliderImgList.add("https://firebasestorage.googleapis.com/v0/b/gcect-app.appspot.com/o/images%2Fhome%20page%20auto%20slider%20images%2Fimg1.jpeg?alt=media&token=4f80327b-d83d-4200-83cd-94eac7bc69a8")
        _autoSliderImgList.add("https://firebasestorage.googleapis.com/v0/b/gcect-app.appspot.com/o/images%2Fhome%20page%20auto%20slider%20images%2Fimg2.jpeg?alt=media&token=d227f9b0-07eb-4f27-a97b-bd355877fcc4")
        _autoSliderImgList.add("https://firebasestorage.googleapis.com/v0/b/gcect-app.appspot.com/o/images%2Fhome%20page%20auto%20slider%20images%2Fimg3.jpeg?alt=media&token=b6d6c39a-6756-4c93-84bc-fa5111493053")
        _autoSliderImgList.add("https://firebasestorage.googleapis.com/v0/b/gcect-app.appspot.com/o/images%2Fhome%20page%20auto%20slider%20images%2Fimg4.jpeg?alt=media&token=3e420b3c-febe-42f6-a245-7e81bd485cba")
        _autoSliderImgList.add("https://firebasestorage.googleapis.com/v0/b/gcect-app.appspot.com/o/images%2Fhome%20page%20auto%20slider%20images%2Fimg5.jpeg?alt=media&token=9b9a4f13-913a-4f09-a976-61a02e468f0d")
        _autoSliderImgList.add("https://firebasestorage.googleapis.com/v0/b/gcect-app.appspot.com/o/images%2Fhome%20page%20auto%20slider%20images%2Fimg6.jpg?alt=media&token=5317af56-c585-4078-aef9-5293353df52b")
        _autoSliderImgList.add("https://firebasestorage.googleapis.com/v0/b/gcect-app.appspot.com/o/images%2Fhome%20page%20auto%20slider%20images%2Fimg7.jpg?alt=media&token=275eadef-fe8d-4fda-b77d-3798bb66b611")
    }

    private fun addGateRankerDetailsToList(){
        _gateRankerList.add(
            GateRankerDetails("Ritesh Kumar Jha",525,
            "https://firebasestorage.googleapis.com/v0/b/gcect-app.appspot.com/o/images%2Fgate%20rankers%2FRiteshKumarJha.jpg?alt=media&token=6320657d-257b-4ed5-9868-32f41b2e027d")
        )
        _gateRankerList.add(GateRankerDetails("Debmalya Sen",539,
        "https://firebasestorage.googleapis.com/v0/b/gcect-app.appspot.com/o/images%2Fgate%20rankers%2FDevmalyaSen.jpg?alt=media&token=b097a52d-0500-4904-a9dd-349103f41259"))
        _gateRankerList.add(GateRankerDetails("Zeba Iqbal",658,
        "https://firebasestorage.googleapis.com/v0/b/gcect-app.appspot.com/o/images%2Fgate%20rankers%2FZebaIqbal.jpg?alt=media&token=42b1478e-54cc-4f3d-8ad4-aa8c1b2b6cad"))
        _gateRankerList.add(GateRankerDetails("Sneha Tiwari",1855,
        "https://firebasestorage.googleapis.com/v0/b/gcect-app.appspot.com/o/images%2Fgate%20rankers%2FSnehaTiwari.jpg?alt=media&token=39586128-0d6d-41f4-9624-0f803eec27de"))
        _gateRankerList.add(GateRankerDetails("Sweta Sarkar",8535,
        "https://firebasestorage.googleapis.com/v0/b/gcect-app.appspot.com/o/images%2Fgate%20rankers%2FSwetaSarkar.jpg?alt=media&token=fb9fabf3-347e-489e-94b0-57e3955a5fb4"))
    }
}