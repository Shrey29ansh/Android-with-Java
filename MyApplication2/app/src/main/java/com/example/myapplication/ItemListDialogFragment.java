package com.example.myapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import java.util.ArrayList;

/**
 * <p>A fragment that shows a list of items as a modal bottom sheet.</p>
 * <p>You can show this modal bottom sheet from your activity like this:</p>
 * <pre>
 *     ItemListDialogFragment.newInstance(30).show(getSupportFragmentManager(), "dialog");
 * </pre>
 */
public class ItemListDialogFragment extends BottomSheetDialogFragment {

    // TODO: Customize parameter argument names
    private static final String ARG_ITEM_COUNT = "item_count";
    static int myPosition;
    public static String[] info = {"C++ was developed by Bjarne Stroustrup, as an extension to the C language." +
            " C++ gives programmers a high level of control over system resources and memory." +
            " The language was updated 3 major times in 2011, 2014, and 2017 to C++11, C++14," +
            " and C++17.","Python is an interpreted, high-level and general-purpose programming" +
            " language. Python's design philosophy emphasizes code readability with its notable" +
            " use of significant whitespace. Its language constructs and object-oriented approach" +
            " aim to help programmers write clear, logical code for small and large-scale projects",
            "is a general-purpose, procedural computer programming language supporting structured" +
                    " programming, lexical variable scope, and recursion, with a static type system." +
                    " By design, C provides constructs that map efficiently to typical machine" +
                    " instructions. It has found lasting use in applications previously coded in" +
                    " assembly language. Such applications include operating systems and various" +
                    " application software for computer architectures that range from supercomputers" +
                    " to PLCs and embedded systems.","Java is a class-based, object-oriented programming " +
            "language that is designed to have as few implementation dependencies as possible. It is" +
            " a general-purpose programming language intended to let application developers write " +
            "once, run anywhere, meaning that compiled Java code can run on all platforms" +
            " that support Java without the need for recompilation.[18] Java applications are " +
            "typically compiled to bytecode that can run on any Java virtual machine (JVM) regardless" +
            " of the underlying computer architecture.","Ruby is an interpreted, high-level, " +
            "general-purpose programming language. It was designed and developed in the mid-1990s by " +
            "Yukihiro \"Matz\" Matsumoto in Japan.Ruby is dynamically typed and uses garbage collection." +
            " It supports multiple programming paradigms, including procedural, object-oriented, and" +
            " functional programming. According to the creator, Ruby was influenced by Perl, Smalltalk," +
            " Eiffel, Ada, BASIC, and Lisp.","JavaScript (JS) is a lightweight, interpreted, or " +
            "just-in-time compiled programming language with first-class functions. While it is most " +
            "well-known as the scripting language for Web pages, many non-browser environments also " +
            "use it, such as Node.js, Apache CouchDB and Adobe Acrobat. JavaScript is a " +
            "prototype-based, multi-paradigm, single-threaded, dynamic language, supporting " +
            "object-oriented, imperative, and declarative (e.g. functional programming) styles. " +
            "Read more about JavaScript."};
    static String LanguageName;
    static int[] indexes;
    static boolean require=false;
    // TODO: Customize parameters
    public static ItemListDialogFragment newInstance(int position, String languageName, int[] myList) {
        myPosition = position;
        indexes = myList;
        require = true;
        LanguageName = languageName;
        return new ItemListDialogFragment();
    }
    public static ItemListDialogFragment newInstance(int position, String languageName) {
        myPosition = position;
        LanguageName = languageName;
        return new ItemListDialogFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.bottom, container, false);
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextView myText,myDesc;
        myText = (TextView) view.findViewById(R.id.nameLanguage);
        myText.setText(LanguageName);
        myDesc = (TextView) view.findViewById(R.id.desc);
        if (require) {
            myDesc.setText(info[indexes[myPosition]]);
        } else {
            myDesc.setText(info[myPosition]);
        }
    }
}