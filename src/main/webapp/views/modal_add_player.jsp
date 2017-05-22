<%--
  Created by IntelliJ IDEA.
  User: petka
  Date: 28.03.2017
  Time: 14:10
  To change this template use File | Settings | File Templates.
--%>
<!-- Modal -->
<div class="modal fade" id="playerModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel">Add player form</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal">
                    <div class="form-group">
                        <label for="firstName" class="col-sm-3 control-label">First Name</label>
                        <div class="col-sm-9">
                            <input type="text" class="form-control" id="firstName" placeholder="First Name">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="lastName" class="col-sm-3 control-label">Last Name</label>
                        <div class="col-sm-9">
                            <input type="text" class="form-control" id="lastName" placeholder="LastName">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="age" class="col-sm-3 control-label">Age</label>
                        <div class="col-sm-9">
                            <input type="number" class="form-control" id="age" placeholder="Age">
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                <button type="button" class="btn btn-primary" id="addPlayer">Add</button>
            </div>
        </div>
    </div>
</div>
