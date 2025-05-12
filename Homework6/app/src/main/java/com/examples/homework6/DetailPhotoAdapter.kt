package com.examples.homework6

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.examples.homework6.databinding.CardDesignForDetailPhotosBinding

class DetailPhotoAdapter (var mContext: Context,var pgotoList: List<Photos>):
    RecyclerView.Adapter<DetailPhotoAdapter.PhotoDesigHolder>()
{
    inner class PhotoDesigHolder(var design: CardDesignForDetailPhotosBinding): RecyclerView.ViewHolder(design.root)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PhotoDesigHolder {
        var binding = CardDesignForDetailPhotosBinding.inflate(LayoutInflater.from(mContext),parent,false)
        return PhotoDesigHolder(binding)
    }

    override fun onBindViewHolder(
        holder: PhotoDesigHolder,
        position: Int
    ) {
        val photo = pgotoList.get(position)
        val t = holder.design
        t.ivDetails.setImageResource(
            mContext.resources.getIdentifier(photo.photoAdress,"drawable",mContext.packageName)
        )
    }

    override fun getItemCount(): Int {
        return pgotoList.size
    }


}