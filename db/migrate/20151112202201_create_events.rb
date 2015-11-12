class CreateEvents < ActiveRecord::Migration
  def change
    create_table :events do |t|
      t.string :title
      t.text :description
      t.string :committee
      t.string :place
      t.integer :creator
      t.integer :privacy
      t.datetime :time
      t.datetime :endtime

      t.timestamps null: false
    end
  end
end
