package com.example.cintaku.Home

import android.content.Context.MODE_PRIVATE
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cintaku.AuthActivity
import com.example.cintaku.Data.api.PhotoApiClient
import com.example.cintaku.Home.pertemuan2.SecondActivity
import com.example.cintaku.Home.pertemuan_10.TenthActivity
import com.example.cintaku.Home.pertemuan_3.ThirdActivity
import com.example.cintaku.Home.pertemuan_4.FourthActivity
import com.example.cintaku.Home.pertemuan_5.FifthActivity
import com.example.cintaku.Home.pertemuan_7.SevenActivity
import com.example.cintaku.Home.pertemuan_9.NinthActivity
import com.example.cintaku.Home.photo.PhotoAdapter
import com.example.cintaku.R
import com.example.cintaku.databinding.FragmentHomeBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import kotlinx.coroutines.launch


class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val sharedPref = requireContext().getSharedPreferences("user_pref", MODE_PRIVATE)

        binding.btnToFourth.setOnClickListener {

            val intent = Intent(requireContext(), FourthActivity::class.java)

            intent.putExtra("name", "Politeknik Caltex Riau")
            intent.putExtra("from", "Rumbai")
            intent.putExtra("age", 25)

            startActivity(intent)
        }

        binding.btnToTwo.setOnClickListener {

            val intent = Intent (requireContext(), SecondActivity::class.java)
            startActivity(intent)
        }

        binding.btnToThree.setOnClickListener {

            val intent = Intent (requireContext(), ThirdActivity::class.java)
            startActivity(intent)
        }

        binding.btnToFive.setOnClickListener {

            val intent = Intent (requireContext(), FifthActivity::class.java)
            startActivity(intent)
        }

        binding.btnToSeven.setOnClickListener {

            val intent = Intent (requireContext(), SevenActivity::class.java)
            startActivity(intent)
        }

        //yang ditambahkan keempat
        binding.btnToNinth.setOnClickListener {

            val intent = Intent (requireContext(), NinthActivity::class.java)
            startActivity(intent)
        }

        binding.btnToTenth.setOnClickListener {

            val intent = Intent (requireContext(), TenthActivity::class.java)
            startActivity(intent)
        }

        binding.btna.setOnClickListener {
            MaterialAlertDialogBuilder(requireContext())
                .setTitle("Konfirmasi")
                .setMessage("Apakah Anda yakin ingin logout?")
                .setPositiveButton("Ya") { dialog, _ ->
                    dialog.dismiss()

                    val editor = sharedPref.edit()
                    editor.clear()
                    editor.apply()

                    val intent = Intent (requireContext(), AuthActivity::class.java)
                    startActivity(intent)
                    requireActivity().finish()
                }
                .setNegativeButton("Batal") { dialog, _ ->
                    dialog.dismiss()
                    Log.e("Info Dialog","Anda memilih Tidak!")
                }
                .show()

        }

        loadPhoto()
        super.onViewCreated(view, savedInstanceState)
    }


    private fun loadPhoto() {
        lifecycleScope.launch {
            try {
                val photos = PhotoApiClient.apiService.getPhotos()
                val adapter = PhotoAdapter(photos)
                binding.rvGallery.adapter = adapter

                /** List Tampil Vertical*/
                binding.rvGallery.layoutManager = LinearLayoutManager(requireContext())

                /** List Tampil Horizontal */
                //binding.rvGallery.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)

                /** List Tampil Grid */
                //binding.rvGallery.layoutManager = GridLayoutManager(requireContext(),2)

            } catch (e: Exception) {
                Toast.makeText(requireContext(), "Gagal memuat gambar", Toast.LENGTH_SHORT).show()
            }
        }
    }
}