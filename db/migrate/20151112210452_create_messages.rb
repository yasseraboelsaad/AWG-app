class CreateMessages < ActiveRecord::Migration
  def change
    create_table :messages do |t|
      t.text :content
      t.integer :sender_id
      t.integer :reciever_id
      t.foreign_key :sender_id 
      t.foreign_key :reciever_id
      t.timestamps null: false
    end
  end
end
