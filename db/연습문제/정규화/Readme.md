1. 다음 릴레이션에서 후보키를 찾아보시오.
HINT  함수 종속성을 보고 결정자 중 기본키가 되는 것들이 있는지를 찾아낸다. 예를 들어 R(A, B, C)에 대해 R에서 성립하는 함수 종속성으로부터 R의 모든 속성을 결정하는 A → ABC와 같은 함수 종속성을 유도할 수 있다면 A가 R의 키가 된다.
    1.  릴레이션: R(A, B, C, D)
    함수 종속성: A → BC, B → A, A → C, A → D, D → A
    
    2. 릴레이션: R(A, B, C, D)
    함수 종속성: A → B, B → C, AC → D
    
    3. 릴레이션: R(A, B, C, D, E)
    함수 종속성: AB → C, CD → E, DE → B
    
    4. 릴레이션: R(A, B, C, D, E)
    함수 종속성: AC → E, C → D, D → A

---

1. 다음은 배송(Shipping) 물품에 대한 릴레이션이다. 물음에 답하시오.
    
    ```sql
    릴레이션: Shipping(shipname, shiptype, voyageID, cargo, port, date)
    함수 종속성: shipname → shiptype
    			voyageID → shipname, cargo
    			shipname, date → voyageID, port
    ```
    
    ![image.png](attachment:bca2fbac-5214-4028-9423-a3d2c5ee2de1:image.png)
    
    A. 후보키를 찾으시오.
    
    B. 제2정규형으로 정규화하시오.
    

C. 제3정규형으로 정규화하시오.

D. BCNF로 정규화하시오.

---

1. 다음은 부품과 공급자에 대한 릴레이션 Part(partnumber, description, supplier, suppaddress, price)이다. 물음에 답하시오.
    
    ![image.png](attachment:6ace59c6-10ed-49a3-8dc9-d48eca3310d2:image.png)
    
    A. 함수 종속성을 찾아보시오.
    
    B. 릴레이션 Part는 어떤 정규형인가?
    

C. 다음과 같이 분해했을 때 각각의 릴레이션은 어떤 정규형인가?
R1(partnumber, description, supplier, price)
R2(supplier, suppaddress)

D. (C)번의 릴레이션에서 분해가 더 필요한가? 필요하면 분해를 수행하시오.
