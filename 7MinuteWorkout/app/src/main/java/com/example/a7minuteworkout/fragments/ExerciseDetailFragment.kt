package com.example.a7minuteworkout.fragments


import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.VideoView
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.example.a7minuteworkout.R
import kotlinx.android.synthetic.main.fragment_exercise_detail.*


class ExerciseDetailFragment : Fragment() {

    var code = ""
    var title  = ""
    var strHints = "  "
    var strbreathing = "  "
    var strCategory = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_exercise_detail, container, false)



        // Inflate the layout for this fragment
        return view
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val args : ExerciseDetailFragmentArgs by navArgs()

        code = args.exercise.code
        title = args.exercise.title

        val hints = args.exercise.instructions.hints
        for (i in 0 until hints.size){
            strHints += getStringByName(hints[i]) + " "
        }

        val breathing = args.exercise.instructions.breathing
        for (i in 0 until breathing.size){
            strbreathing += getStringByName(breathing[i]) + " "
        }



        if(args.exercise.category.balance > 0) strCategory += "تعادل ،"
        if(args.exercise.category.cardio > 0) strCategory += "هوازی ،"
        if(args.exercise.category.core > 0) strCategory += "هسته ،"
        if(args.exercise.category.lower_body > 0) strCategory += "پایین تنه ،"
        if(args.exercise.category.plyometric > 0) strCategory += "Polimetric ،"
        if(args.exercise.category.shoulder_and_back > 0) strCategory += "شانه و پشت ،"
        if(args.exercise.category.stretching > 0) strCategory += "کششی ،"
        if(args.exercise.category.upper_body > 0) strCategory += "بالا تنه ،"
        if(args.exercise.category.warmup > 0) strCategory += "گرم کردن ،"
        if(args.exercise.category.yoga > 0) strCategory += "یوگا ،"

        tvhints.text = strHints
        tvBreathing.text = strbreathing
        tvTitle.text = args.exercise.title
        tvCategory.text = strCategory.dropLast(1)

        setUpVideo()

        btnBack.setOnClickListener {
            Navigation.findNavController(it).popBackStack()
        }

    }


    fun getStringByName(name: String): String {
        return resources.getString(resources.getIdentifier(name, "string", getActivity()?.getPackageName()))
    }


    fun setUpVideo(){
        val view = vView as VideoView
        val path = "android.resource://" + activity!!.packageName + "/raw/" + code
        view.setVideoURI(Uri.parse(path))
        view.start()
        view.setOnCompletionListener { view.start() }


    }
}