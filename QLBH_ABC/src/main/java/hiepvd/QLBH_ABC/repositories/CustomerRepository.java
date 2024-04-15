package hiepvd.QLBH_ABC.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import hiepvd.QLBH_ABC.models.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> { //Tên thực thể, kiểu dữ liệu của trường khóa(ID)
	//có thể xây thêm các phương thức khác ở đây
}
