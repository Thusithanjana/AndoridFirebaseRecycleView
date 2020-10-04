## README
This application is created to demonstrate the usage of RecyclerView in Android applications.

## Important files to look at:
* res -> xml -> network_security_config.xml
* google-services.json
* layout -> my_text_view.xml

## Important Codes:

# Setting text in a cardview
```java
ConstraintLayout layout = (ConstraintLayout) holder.cardView.getChildAt(0);
        Log.i(TAG, "onBindViewHolder: "+layout);
        TextView tvName = (TextView) layout.getChildAt(0);
        TextView tvId = (TextView) layout.getChildAt(1);
        TextView tvEmail = (TextView) layout.getChildAt(2);
        TextView tvPhone = (TextView) layout.getChildAt(3);

        tvName.setText(mDataset.get(position).getStudentName());
        tvId.setText(mDataset.get(position).getStudentId());
        tvEmail.setText(mDataset.get(position).getEmail());
        tvPhone.setText(mDataset.get(position).getPhoneNo());

```
# Retrieving all Data from firebase at once
```java
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_view_all);
    ...

    final List <Student> myDataset = new ArrayList<Student>();

    dbRef = FirebaseDatabase.getInstance().getReference().child("Student");
    dbRef.addListenerForSingleValueEvent(new ValueEventListener() {
        @Override
        public void onDataChange(@NonNull DataSnapshot snapshot) {
            for(DataSnapshot ds : snapshot.getChildren()){
                Student std =  ds.getValue(Student.class);
                Log.i(TAG, "onDataChange: "+ std.getStudentName());
                myDataset.add(std);
            }
            mAdapter = new StudentAdapter(myDataset);
            recyclerView.setAdapter(mAdapter);


         }
         ...
    }

```